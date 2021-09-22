import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.Multiplatform)
    if (org.gradle.internal.os.OperatingSystem.current() == org.gradle.internal.os.OperatingSystem.MAC_OS) {
        kotlin(iOSPlugins.NativeCocoapods)
    }
    id(AndroidPlugins.AndroidLibrary)
}

version = "0.1.0-dev01"

kotlin {
    val isOSX =
        org.gradle.internal.os.OperatingSystem.current() == org.gradle.internal.os.OperatingSystem.MAC_OS
    android()
    jvm()
    js(IR) {
        useCommonJs()
        browser()
    }

    if (isOSX) {
        val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
            System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
            System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
            else -> ::iosX64
        }

        iosTarget("ios") {}

        cocoapods {
            summary = "Some description for the Shared Module"
            homepage = "Link to the Shared Module homepage"
            ios.deploymentTarget = "14.1"
            podfile = project.file("../ios/Podfile")

            framework {
                baseName = Modules.SharedModule
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(TestLibraries.jUnit4)
            }
        }
        if (isOSX) {
            val iosMain by getting
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
