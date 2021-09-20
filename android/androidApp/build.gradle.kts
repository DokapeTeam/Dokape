plugins {
    id(AndroidPlugins.AndroidApplication)
    kotlin(AndroidPlugins.KotlinAndroid)
    kotlin(AndroidPlugins.KotlinKapt)
}

group = Configs.GroupId
version = Configs.VersionName

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
    androidTestImplementation(AndroidTest.ComposeUIJUnit4)
}

android {
    buildToolsVersion = AndroidVersions.BuildToolsVersion
    compileSdk = AndroidConfigs.CompileSdkVersion
    defaultConfig {
        applicationId = Configs.ApplicationId
        minSdk = AndroidConfigs.MinSdkVersion
        targetSdk = AndroidConfigs.TargetSdkVersion
        versionCode = AndroidConfigs.VersionCode
        versionName = Configs.VersionName
    }

    buildTypes {
        getByName(AndroidBuildTypes.Release) {
            isMinifyEnabled = false
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AndroidVersions.ComposeVersion
    }
}
