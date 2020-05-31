package com.apollographql.apollo.network.websocket

import com.apollographql.apollo.ApolloWebSocketException
import com.apollographql.apollo.network.toNSData
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.staticCFunction
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import okio.ByteString
import okio.ByteString.Companion.toByteString
import okio.IOException
import okio.internal.commonAsUtf8ToByteArray
import okio.toByteString
import platform.Foundation.NSData
import platform.Foundation.NSError
import platform.Foundation.NSMutableURLRequest
import platform.Foundation.NSOperationQueue
import platform.Foundation.NSThread
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.Foundation.NSURLSession
import platform.Foundation.NSURLSessionConfiguration
import platform.Foundation.NSURLSessionWebSocketCloseCode
import platform.Foundation.NSURLSessionWebSocketDelegateProtocol
import platform.Foundation.NSURLSessionWebSocketMessage
import platform.Foundation.NSURLSessionWebSocketMessageTypeData
import platform.Foundation.NSURLSessionWebSocketMessageTypeString
import platform.Foundation.NSURLSessionWebSocketTask
import platform.Foundation.setHTTPMethod
import platform.Foundation.setValue
import platform.darwin.NSObject
import platform.darwin.dispatch_async_f
import platform.darwin.dispatch_get_main_queue
import kotlin.native.concurrent.ensureNeverFrozen
import kotlin.native.concurrent.freeze

interface WebSocketConnectionListener {
  fun onOpen(webSocket: NSURLSessionWebSocketTask)

  fun onClose(webSocket: NSURLSessionWebSocketTask, code: NSURLSessionWebSocketCloseCode)
}

typealias NSWebSocketFactory = (NSURLRequest, WebSocketConnectionListener) -> NSURLSessionWebSocketTask

@ExperimentalCoroutinesApi
actual class WebSocketFactory(
    private val request: NSURLRequest,
    private val webSocketFactory: NSWebSocketFactory
) {

  actual constructor(
      serverUrl: String,
      headers: Map<String, String>
  ) : this(
      request = NSMutableURLRequest.requestWithURL(NSURL(string = serverUrl)).apply {
        headers.forEach { (key, value) -> setValue(value, forHTTPHeaderField = key) }
        setHTTPMethod("GET")
      },
      webSocketFactory = { request, connectionListener ->
        NSURLSession.sessionWithConfiguration(
            configuration = NSURLSessionConfiguration.defaultSessionConfiguration,
            delegate = NSURLSessionWebSocketDelegate(connectionListener),
            delegateQueue = NSOperationQueue.mainQueue
        ).webSocketTaskWithRequest(request)
      }
  )

  actual suspend fun open(): WebSocketConnection {
    assert(NSThread.isMainThread())

    val messageChannel = Channel<ByteString>(Channel.BUFFERED)
    val isOpen = CompletableDeferred<Boolean>()

    val connectionListener = object : WebSocketConnectionListener {
      override fun onOpen(webSocket: NSURLSessionWebSocketTask) {
        if (!isOpen.complete(true)) {
          webSocket.cancel()
        }
      }

      override fun onClose(webSocket: NSURLSessionWebSocketTask, code: NSURLSessionWebSocketCloseCode) {
        isOpen.cancel()
        messageChannel.close()
      }
    }

    val webSocket = webSocketFactory(request, connectionListener)
        .apply { resume() }

    try {
      isOpen.await()
      return WebSocketConnection(
          webSocket = webSocket,
          messageChannel = messageChannel.apply { ensureNeverFrozen() }
      )
    } catch (e: Exception) {
      webSocket.cancel()
      throw e
    }
  }
}

@ExperimentalCoroutinesApi
actual class WebSocketConnection(
    internal val webSocket: NSURLSessionWebSocketTask,
    internal val messageChannel: Channel<ByteString>
) : ReceiveChannel<ByteString> by messageChannel {

  init {
    messageChannel.invokeOnClose {
      webSocket.cancelWithCloseCode(
          closeCode = 1001,
          reason = null
      )
    }
    receiveNext()
  }

  @Suppress("NAME_SHADOWING")
  actual fun send(data: ByteString) {
    assert(NSThread.isMainThread())
    if (!messageChannel.isClosedForReceive) {
      val message = NSURLSessionWebSocketMessage(data.toByteArray().toNSData())
      val webSocketConnectionPtr = StableRef.create(this).asCPointer()
      val completionHandler = { error: NSError? ->
        error?.dispatchOnMain(webSocketConnectionPtr)
        Unit
      }.freeze()
      webSocket.sendMessage(message, completionHandler)
    }
  }

  actual fun close() {
    assert(NSThread.isMainThread())
    messageChannel.close()
  }

  @Suppress("NAME_SHADOWING")
  internal fun receiveNext() {
    assert(NSThread.isMainThread())

    val webSocketConnectionPtr = StableRef.create(this).asCPointer()
    val completionHandler = { message: NSURLSessionWebSocketMessage?, error: NSError? ->
      error?.dispatchOnMain(webSocketConnectionPtr) ?: message?.dispatchOnMainAndRequestNext(webSocketConnectionPtr)
      Unit
    }
    webSocket.receiveMessageWithCompletionHandler(completionHandler)
  }
}

@Suppress("NAME_SHADOWING")
@ExperimentalCoroutinesApi
private fun NSError.dispatchOnMain(webSocketConnectionPtr: COpaquePointer) {
  dispatch_async_f(
      queue = dispatch_get_main_queue(),
      context = StableRef.create(freeze() to webSocketConnectionPtr).asCPointer(),
      work = staticCFunction { ptr ->
        val errorAndWebSocketConnectionRef = ptr!!.asStableRef<Pair<NSError, COpaquePointer>>()

        val (error, webSocketConnectionPtr) = errorAndWebSocketConnectionRef.get()
        errorAndWebSocketConnectionRef.dispose()

        val webSocketConnectionRef = webSocketConnectionPtr.asStableRef<WebSocketConnection>()
        val webSocketConnection = webSocketConnectionRef.get()
        webSocketConnectionRef.dispose()

        webSocketConnection.messageChannel.close(
            ApolloWebSocketException(
                message = "Web socket communication error",
                cause = IOException(error.localizedDescription)
            )
        )
        webSocketConnection.webSocket.cancel()
      }
  )
}

@Suppress("NAME_SHADOWING")
@ExperimentalCoroutinesApi
private fun NSURLSessionWebSocketMessage.dispatchOnMainAndRequestNext(webSocketConnectionPtr: COpaquePointer) {
  dispatch_async_f(
      queue = dispatch_get_main_queue(),
      context = StableRef.create(freeze() to webSocketConnectionPtr).asCPointer(),
      work = staticCFunction { ptr ->
        val messageAndWebSocketConnectionRef = ptr!!.asStableRef<Pair<NSURLSessionWebSocketMessage, COpaquePointer>>()

        val (message, webSocketConnectionPtr) = messageAndWebSocketConnectionRef.get()
        messageAndWebSocketConnectionRef.dispose()

        val webSocketConnectionRef = webSocketConnectionPtr.asStableRef<WebSocketConnection>()
        val webSocketConnection = webSocketConnectionRef.get()
        webSocketConnectionRef.dispose()

        val data = when (message.type) {
          NSURLSessionWebSocketMessageTypeData -> {
            message.data?.toByteString()
          }

          NSURLSessionWebSocketMessageTypeString -> {
            message.string?.commonAsUtf8ToByteArray()?.toByteString()
          }

          else -> null
        }

        try {
          if (data != null) webSocketConnection.messageChannel.offer(data)
        } catch (e: Exception) {
          webSocketConnection.webSocket.cancel()
          return@staticCFunction
        }

        webSocketConnection.receiveNext()
      }
  )
}


private class NSURLSessionWebSocketDelegate(
    val webSocketConnectionListener: WebSocketConnectionListener
) : NSObject(), NSURLSessionWebSocketDelegateProtocol {

  override fun URLSession(session: NSURLSession, webSocketTask: NSURLSessionWebSocketTask, didOpenWithProtocol: String?) {
    webSocketConnectionListener.onOpen(webSocketTask)
  }

  override fun URLSession(session: NSURLSession, webSocketTask: NSURLSessionWebSocketTask, didCloseWithCode: NSURLSessionWebSocketCloseCode, reason: NSData?) {
    webSocketConnectionListener.onClose(webSocket = webSocketTask, code = didCloseWithCode)
  }
}
