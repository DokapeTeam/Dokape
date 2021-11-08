object Libraries {
    const val CoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.CoroutinesVersion}"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.CoroutinesVersion}"
    const val Reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KotlinVersion}"
    const val SerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.SerializationJsonVersion}"
    const val Koin = "io.insert-koin:koin-core:${Versions.Koin}"
    const val Kermit = "co.touchlab:kermit:${Versions.Kermit}"
    const val KtorCore = "io.ktor:ktor-client-core:${Versions.Ktor}"
    const val KtorCIO = "io.ktor:ktor-client-cio:${Versions.Ktor}"
    const val KtorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.Ktor}"
    const val KtorClientLogging = "io.ktor:ktor-client-logging:${Versions.Ktor}"
}

object AndroidLibraries {
    const val Material = "com.google.android.material:material:${AndroidVersions.MaterialVersion}"
    const val AppCompat = "androidx.appcompat:appcompat:${AndroidVersions.AppCompat}"
    const val ComposeUI = "androidx.compose.ui:ui:${AndroidVersions.ComposeVersion}"
    const val ComposeUITooling = "androidx.compose.ui:ui-tooling:${AndroidVersions.ComposeVersion}"
    const val ComposeFoundation =
        "androidx.compose.foundation:foundation:${AndroidVersions.ComposeVersion}"
    const val ComposeMaterial =
        "androidx.compose.material:material:${AndroidVersions.ComposeVersion}"
    const val ComposeMaterialIconsCore =
        "androidx.compose.material:material-icons-core:${AndroidVersions.ComposeVersion}"
    const val ComposeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${AndroidVersions.ComposeVersion}"
    const val ComposeLiveData =
        "androidx.compose.runtime:runtime-livedata:${AndroidVersions.ComposeVersion}"
    const val CoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${AndroidVersions.CoroutinesAndroidVersion}"
    const val AndroidXCore = "androidx.core:core-ktx:${AndroidVersions.AndroidXCoreVersion}"
    const val Timber = "com.jakewharton.timber:timber:${AndroidVersions.TimberVersion}"

    //Firebase
    const val FirebaseBoM = "com.google.firebase:firebase-bom:${AndroidVersions.FirebaseBoM}"
    const val FirebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"

    const val ActivityCompose =
        "androidx.activity:activity-compose:${AndroidVersions.ActivityCompose}"
    const val SQLDelightAndroid = "com.squareup.sqldelight:android-driver:${Versions.SQLDelight}"
    const val KoinAndroid = "io.insert-koin:koin-android:${Versions.Koin}"
    const val KoinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.Koin}"
    const val KoinJetpackCompose = "io.insert-koin:koin-androidx-compose:${Versions.Koin}"
    const val KtorAndroid = "io.ktor:ktor-client-android:${Versions.Ktor}"

    const val WorkManager = "androidx.work:work-runtime-ktx:${AndroidVersions.WorkManager}"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidVersions.Lifecycle}"
    const val LifecycleSaveState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${AndroidVersions.Lifecycle}"
    const val LifecycleCommonJava8 =
        "androidx.lifecycle:lifecycle-common-java8:${AndroidVersions.Lifecycle}"
    const val LifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidVersions.Lifecycle}"
    const val LifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidVersions.Lifecycle}"

    const val NavigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${AndroidVersions.NavigationComponent}"
    const val NavigationUi =
        "androidx.navigation:navigation-ui-ktx:${AndroidVersions.NavigationComponent}"
    const val NavigationDynamic =
        "androidx.navigation:navigation-dynamic-features-fragment:${AndroidVersions.NavigationComponent}"
    const val NavigationCompose =
        "androidx.navigation:navigation-compose:${AndroidVersions.NavigationComponent}"

    const val Coil = "io.coil-kt:coil:${AndroidVersions.Coil}"
}

object AndroidTestLibraries {
    const val ComposeUIJUnit4 =
        "androidx.compose.ui:ui-test-junit4:${AndroidVersions.ComposeVersion}"
    const val AndroidTestEspresso = "androidx.test.espresso:espresso-core:3.3.0"
    const val AndroidTestJUnit4 = "androidx.test.ext:junit:1.1.2"

    const val NavigationTesting =
        "androidx.navigation:navigation-testing:${AndroidVersions.NavigationComponent}"
}

object TestLibraries {
    const val jUnit4 = "junit:junit:${AndroidVersions.JUnit4}"
    const val KoinTest = "io.insert-koin:koin-test:${Versions.Koin}"
    const val KoinJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.Koin}"
}

object AnnotationProcessor

object IOSLibraries {
    const val SQLDelightNative = "com.squareup.sqldelight:native-driver:${Versions.SQLDelight}"
    const val KtorIOS = "io.ktor:ktor-client-ios:${Versions.Ktor}"
}
