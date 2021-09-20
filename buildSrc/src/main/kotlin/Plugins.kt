
object Plugins {
    const val Multiplatform = "multiplatform"
    const val AndroidLibrary = "com.android.library"
}

object ProjectPlugins {
    const val KotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KotlinVersion}"
    const val AndroidGradlePlugin =
        "com.android.tools.build:gradle:${AndroidVersions.AndroidGradlePluginVersion}"
}

object AndroidPlugins {
    const val AndroidApplication = "com.android.application"
    const val KotlinAndroid = "android"
    const val KotlinKapt = "kapt"
}

object iOSPlugins {}
