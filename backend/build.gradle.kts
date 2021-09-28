plugins {
    application
    kotlin("jvm")
}

group = Configs.GroupId
version = "0.1.0-dev01"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(Modules.SharedModule))
    implementation(kotlin("stdlib"))
    implementation(kotlin("test"))
    implementation(BackendLibraries.KtorCore)
    implementation(BackendLibraries.KtorNettyEngine)
    implementation(BackendLibraries.LogBack)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs =
        kotlinOptions.freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
}

sourceSets.all {
    java.srcDir("src/$name/kotlin")
}

application {
    mainClass.set("com.dokapegroup.backend.ApplicationKt")
}
