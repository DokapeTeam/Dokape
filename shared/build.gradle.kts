import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.Multiplatform)
    kotlin(IOSPlugins.NativeCocoapods)
    id(AndroidPlugins.AndroidLibrary)
    kotlin(Plugins.Serialization) version Versions.KotlinVersion
    id(Plugins.SQLDelight)
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

version = "0.1.0-dev01"

android {
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    val isOSX =
        org.gradle.internal.os.OperatingSystem.current().isMacOsX
    android()
    jvm()
    js(IR) {
        useCommonJs()
        browser {
            webpackTask {
                output.libraryTarget = "commonjs2"
            }
        }
    }

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    if (isOSX) iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")

        framework {
            baseName = Modules.SharedModule
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))

                // Logger
                api(Libraries.Kermit)

                // Coroutines
                implementation(Libraries.CoroutinesCore)

                // Serialization
                implementation(Libraries.SerializationJson)

                // Koin for DI
                api(Libraries.Koin)
                api(TestLibraries.KoinTest)

                implementation(Libraries.KtorCore)
                implementation(Libraries.KtorClientSerialization)
                implementation(Libraries.KtorClientLogging)
            }
        }
        val commonTest by getting {
            dependencies {
                // Test libraries
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Core support libraries
                implementation(AndroidLibraries.AndroidXCore)
                implementation(AndroidLibraries.AppCompat)
                implementation(AndroidLibraries.CoroutinesAndroid)

                // Serialization Json JVM
                implementation(Libraries.SerializationJson)

                // SQLDelight android driver
                implementation(AndroidLibraries.SQLDelightAndroid)

                // Ktor Client
                implementation(AndroidLibraries.KtorAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(TestLibraries.jUnit4)
                implementation(Libraries.CoroutinesTest)
            }
        }
        if (isOSX) {
            val iosMain by getting {
                dependencies {
                    implementation(IOSLibraries.SQLDelightNative)
                }
            }
            val iosTest by getting
        }
        val jsMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:sqljs-driver:${Versions.SQLDelight}")
            }
        }
    }

    targets.all {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
                freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjsr305=strict")
            }
        }
    }
}

android {
    compileSdk = AndroidConfigs.CompileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidConfigs.MinSdkVersion
        targetSdk = AndroidConfigs.TargetSdkVersion
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjsr305=strict")
}

sqldelight {
    database("DokapeDatabase") { // This will be the name of the generated database class.
        packageName = Configs.GroupId
        dialect = "mysql"
    }
}
