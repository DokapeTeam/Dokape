buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectPlugins.AndroidGradlePlugin)
        classpath(ProjectPlugins.KotlinGradlePlugin)
    }
}

group = Configs.GroupId

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
        maven(url = "https://jitpack.io")
    }
}
