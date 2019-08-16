package com.apollographql.apollo.api

interface ResponseWriter {
  fun writeString(field: ResponseField, value: String?)

  fun writeInt(field: ResponseField, value: Int?)

  fun writeLong(field: ResponseField, value: Long?)

  fun writeDouble(field: ResponseField, value: Double?)

  fun writeBoolean(field: ResponseField, value: Boolean?)

  fun writeCustom(field: ResponseField.CustomTypeField, value: Any?)

  fun writeObject(field: ResponseField, marshaller: ResponseFieldMarshaller?)

  fun <T> writeList(field: ResponseField, values: List<T>?, listWriter: ListWriter<T>)

  interface ListWriter<T> {
    fun write(items: List<T>?, listItemWriter: ListItemWriter)
  }

  interface ListItemWriter {
    fun writeString(value: String?)

    fun writeInt(value: Int?)

    fun writeLong(value: Long?)

    fun writeDouble(value: Double?)

    fun writeBoolean(value: Boolean?)

    fun writeCustom(scalarType: ScalarType, value: Any?)

    fun writeObject(marshaller: ResponseFieldMarshaller?)

    fun <T> writeList(items: List<T>?, listWriter: ListWriter<T>)
  }
}
