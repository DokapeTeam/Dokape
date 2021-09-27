object Plugins {
    const val Multiplatform = "multiplatform"
    const val JetBrainsCompose = "org.jetbrains.compose"
    const val Serialization = "plugin.serialization"
    const val Spring = "plugin.spring"
    const val Jvm = "jvm"
    const val Jpa = "plugin.jpa"
    const val SpringBoot = "org.springframework.boot"
    const val SpringDependencyManagement = "io.spring.dependency-management"
    const val SQLDelight = "com.squareup.sqldelight"
}

object ProjectPlugins {
    const val KotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KotlinVersion}"
    const val AndroidGradlePlugin =
        "com.android.tools.build:gradle:${AndroidVersions.AndroidGradlePluginVersion}"
    const val SQLDelightPlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.SQLDelight}"
}

object AndroidPlugins {
    const val AndroidApplication = "com.android.application"
    const val KotlinAndroid = "android"
    const val KotlinKapt = "kapt"
    const val AndroidLibrary = "com.android.library"
}

object IOSPlugins {
    const val NativeCocoapods = "native.cocoapods"
}
