import org.jetbrains.compose.compose

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.0.0-alpha3"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
