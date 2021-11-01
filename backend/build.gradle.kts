import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    kotlin("plugin.allopen") version "1.5.31"
}

group = "com.dokapegroup"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.6")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.31")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.31")
    runtimeOnly("com.h2database:h2:1.4.200")
    runtimeOnly("org.postgresql:postgresql:42.3.0")
    implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.5.6")
    implementation("org.springframework.data:spring-data-keyvalue:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-security:2.5.6")
    implementation("org.springframework.security:spring-security-oauth2-resource-server:5.5.3")
    implementation("org.springframework.security:spring-security-oauth2-jose:5.5.3")
    implementation("org.springframework.security:spring-security-config:5.5.3")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("org.springframework.boot:spring-boot-starter-parent:2.5.6")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.5.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
