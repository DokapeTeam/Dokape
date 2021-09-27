import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.Multiplatform)
    kotlin(IOSPlugins.NativeCocoapods)
    id(AndroidPlugins.AndroidLibrary)
    kotlin(Plugins.Serialization) version Versions.KotlinVersion
    id(Plugins.SQLDelight)
}

version = "0.1.0-dev01"

kotlin {
    val isOSX =
        org.gradle.internal.os.OperatingSystem.current().isMacOsX
    android()
    jvm()
    js(IR) {
        useCommonJs()
        browser()
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
                implementation(Libraries.CoroutinesCore)
                implementation(Libraries.SerializationJson)
                implementation(Libraries.Koin)
                implementation(TestLibraries.KoinTest)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(AndroidLibraries.AndroidXCore)
                implementation(AndroidLibraries.AppCompat)
                implementation(AndroidLibraries.CoroutinesAndroid)
                implementation(AndroidLibraries.Timber)
                implementation(Libraries.SerializationJson)
                implementation(AndroidLibraries.SQLDelightAndroid)
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
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(TestLibraries.jUnit4)
            }
        }
        val jsMain by getting
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
    kotlinOptions.freeCompilerArgs =
        kotlinOptions.freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
}

sqldelight {
    database(Configs.ApplicationName) { // This will be the name of the generated database class.
        packageName = Configs.GroupId
    }
}
