plugins {
    kotlin(Plugins.Jpa) version Versions.KotlinVersion
    id(Plugins.SpringBoot) version BackendVersions.SpringVersion
    id(Plugins.SpringDependencyManagement) version BackendVersions.SpringDependencyManagement
    kotlin(Plugins.Jvm)
    kotlin(Plugins.Spring) version Versions.KotlinVersion
    kotlin(Plugins.Serialization) version Versions.KotlinVersion
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
    implementation(BackendLibraries.SpringBootStarter)
    implementation(BackendLibraries.SpringBootStarterMustache)
    implementation(BackendLibraries.SpringBootWeb)
    implementation(Libraries.Reflect)
    runtimeOnly("com.h2database:h2:1.4.200")
    runtimeOnly(BackendLibraries.SpringBootDevTools)
    testImplementation(BackendLibraries.SpringBootTestStarter)
    implementation(Libraries.SerializationJson)
    implementation(BackendLibraries.SpringBootStarterParent)
    implementation(BackendLibraries.SpringFoxSwagger2)
    implementation(BackendLibraries.SpringFoxBootStarter)
    implementation(BackendLibraries.SpringFoxSwaggerUi)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs =
        listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjsr305=strict")
}

sourceSets.all {
    java.srcDir("src/$name/kotlin")
}
