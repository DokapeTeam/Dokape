pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "Dokape"
include(":android:androidApp")
include(":shared")
include(":desktop")
include(":android:network")
