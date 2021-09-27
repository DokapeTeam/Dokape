object Libraries {
    const val CoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.CoroutinesVersion}"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.CoroutinesVersion}"
    const val Reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KotlinVersion}"
    const val SerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.SerializationJsonVersion}"
    const val Koin = "io.insert-koin:koin-core:${Versions.Koin}"
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
    const val ActivityCompose =
        "androidx.activity:activity-compose:${AndroidVersions.ActivityCompose}"
    const val SQLDelightAndroid = "com.squareup.sqldelight:android-driver:${Versions.SQLDelight}"
    const val KoinAndroid = "io.insert-koin:koin-android:${Versions.Koin}"
    const val KoinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.Koin}"
    const val KoinJetpackCompose = "io.insert-koin:koin-androidx-compose:${Versions.Koin}"
}

object AndroidTestLibraries {
    const val ComposeUIJUnit4 =
        "androidx.compose.ui:ui-test-junit4:${AndroidVersions.ComposeVersion}"
}

object TestLibraries {
    const val jUnit4 = "junit:junit:${AndroidVersions.JUnit4}"
    const val KoinTest = "io.insert-koin:koin-test:${Versions.Koin}"
    const val KoinJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.Koin}"
}

object AnnotationProcessor

object IOSLibraries {
    const val SQLDelightNative = "com.squareup.sqldelight:native-driver:${Versions.SQLDelight}"
}

object BackendLibraries {
    const val SpringBootStarter =
        "org.springframework.boot:spring-boot-starter-data-jpa:${BackendVersions.SpringVersion}"
    const val SpringBootStarterMustache =
        "org.springframework.boot:spring-boot-starter-mustache:${BackendVersions.SpringVersion}"
    const val SpringBootWeb =
        "org.springframework.boot:spring-boot-starter-web:${BackendVersions.SpringVersion}"
    const val SpringBootDevTools =
        "org.springframework.boot:spring-boot-devtools:${BackendVersions.SpringVersion}"
    const val SpringBootStarterParent =
        "org.springframework.boot:spring-boot-starter-parent:${BackendVersions.SpringVersion}"
    const val SpringBootTestStarter =
        "org.springframework.boot:spring-boot-starter-test:${BackendVersions.SpringVersion}"
    const val SpringFoxSwagger2 = "io.springfox:springfox-swagger2:${BackendVersions.SpringFox}"
    const val SpringFoxBootStarter =
        "io.springfox:springfox-boot-starter:${BackendVersions.SpringFox}"
    const val SpringFoxSwaggerUi = "io.springfox:springfox-swagger-ui:${BackendVersions.SpringFox}"
}
