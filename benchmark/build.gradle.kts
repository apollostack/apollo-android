buildscript {
  apply(from = "../gradle/dependencies.gradle")

  repositories {
    google()
    mavenCentral()
    jcenter()
    mavenLocal()
    maven {
      url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
  }
  dependencies {
    classpath(groovy.util.Eval.x(project, "x.dep.android.plugin"))
    classpath(groovy.util.Eval.x(project, "x.dep.kotlin.plugin"))
    classpath(groovy.util.Eval.x(project, "x.dep.kspGradlePlugin"))

    classpath("com.apollographql.apollo3:apollo-gradle-plugin:${properties.get("apolloVersion")}")
    classpath("androidx.benchmark:benchmark-gradle-plugin:1.0.0")
  }
}

apply(plugin = "com.android.library")
apply(plugin = "org.jetbrains.kotlin.android")
apply(plugin = "com.apollographql.apollo3")
apply(plugin = "androidx.benchmark")
apply(plugin = "com.google.devtools.ksp")

repositories {
  google()
  mavenCentral()
  jcenter()
  mavenLocal()
  maven {
    url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
  }
}

dependencies {
  add("implementation", "com.apollographql.apollo3:apollo-runtime:${properties.get("apolloVersion")}")
  add("implementation", "com.apollographql.apollo3:apollo-api:${properties.get("apolloVersion")}")
  add("implementation", "com.apollographql.apollo3:apollo-normalized-cache-sqlite:${properties.get("apolloVersion")}")

  add("implementation", groovy.util.Eval.x(project, "x.dep.moshi.moshi"))
  add("ksp", groovy.util.Eval.x(project, "x.dep.moshi.kotlinCodegen"))

  add("androidTestImplementation", "androidx.benchmark:benchmark-junit4:1.0.0")
}

configure<com.android.build.gradle.LibraryExtension> {
  compileSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.compileSdkVersion").toString().toInt())

  defaultConfig {
    minSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.minSdkVersion").toString())
    targetSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.targetSdkVersion").toString())
    testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  useLibrary("android.test.base")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }
}

plugins.withType(org.gradle.api.plugins.JavaPlugin::class.java) {
  extensions.configure(JavaPluginExtension::class.java) {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}

configure<com.apollographql.apollo3.gradle.api.ApolloExtension> {
}
