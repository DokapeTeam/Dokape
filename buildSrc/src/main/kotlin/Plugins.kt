
object Plugins {
    const val Multiplatform = "multiplatform"
    const val JetBrainsCompose = "org.jetbrains.compose"
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
    const val AndroidLibrary = "com.android.library"
}

object iOSPlugins {
    const val NativeCocoapods = "native.cocoapods"
}
