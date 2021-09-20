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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

group = Configs.GroupId
version = Configs.VersionName

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}