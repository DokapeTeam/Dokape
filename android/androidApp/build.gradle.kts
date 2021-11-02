plugins {
    id(AndroidPlugins.AndroidApplication)
    kotlin(AndroidPlugins.KotlinAndroid)
    kotlin(AndroidPlugins.KotlinKapt)
}

group = Configs.GroupId

dependencies {
    implementation(project(Modules.SharedModule))
    implementation(AndroidLibraries.Material)
    implementation(AndroidLibraries.AppCompat)
    implementation(AndroidLibraries.ComposeUI)
    // Tooling support (Previews, etc.)
    implementation(AndroidLibraries.ComposeUITooling)
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(AndroidLibraries.ComposeFoundation)
    // Material Design
    implementation(AndroidLibraries.ComposeMaterial)
    // Material design icons
    implementation(AndroidLibraries.ComposeMaterialIconsCore)
    implementation(AndroidLibraries.ComposeMaterialIconsExtended)
    // Integration with observables
    implementation(AndroidLibraries.ComposeLiveData)

    // UI Tests
    androidTestImplementation(AndroidTestLibraries.ComposeUIJUnit4)

    //Firebase
    implementation(platform(AndroidLibraries.FirebaseBoM))
    implementation(AndroidLibraries.FirebaseAnalytics)
    // Koin
    implementation(AndroidLibraries.KoinAndroid)
    implementation(AndroidLibraries.KoinWorkManager)
    implementation(AndroidLibraries.KoinJetpackCompose)
}

android {
    buildToolsVersion = AndroidVersions.BuildToolsVersion
    compileSdk = AndroidConfigs.CompileSdkVersion
    defaultConfig {
        applicationId = Configs.ApplicationId
        minSdk = AndroidConfigs.MinSdkVersion
        targetSdk = AndroidConfigs.TargetSdkVersion
        versionCode = AndroidConfigs.ReleaseVersionCode
        versionName = AndroidConfigs.ReleaseVersionName
    }

    buildTypes {
        getByName(AndroidBuildTypes.Release) {
            isMinifyEnabled = false
        }
        getByName(AndroidBuildTypes.Debug) {
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev${AndroidConfigs.DebugVersionCode.toString().padStart(2, '0')}"
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidVersions.ComposeVersion
    }

    sourceSets.all {
        kotlin.srcDir("src/$name/kotlin")
    }

    applicationVariants.all {
        outputs.forEach {
            val output = (it as com.android.build.gradle.internal.api.ApkVariantOutputImpl)
            if (output.name == AndroidBuildTypes.Debug) {
                output.versionCodeOverride = AndroidConfigs.DebugVersionCode
                output.versionNameOverride = AndroidConfigs.DebugVersionName
            } else {
                output.versionCodeOverride = AndroidConfigs.ReleaseVersionCode
                output.versionNameOverride = AndroidConfigs.ReleaseVersionName
            }
        }
    }
}
