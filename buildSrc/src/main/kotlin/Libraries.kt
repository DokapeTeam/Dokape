object Libraries {
    const val CoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.CoroutinesVersion}"
    const val CoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.CoroutinesVersion}"
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
    const val ActivityCompose = "androidx.activity:activity-compose:${AndroidVersions.ActivityCompose}"

    //Firebase
    const val FirebaseBoM = "com.google.firebase:firebase-bom:${AndroidVersions.FirebaseBoM}"
    const val FirebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"

}

object AndroidTestLibraries {
    const val ComposeUIJUnit4 =
        "androidx.compose.ui:ui-test-junit4:${AndroidVersions.ComposeVersion}"
}

object TestLibraries {
    const val jUnit4 = "junit:junit:${AndroidVersions.JUnit4}"
}

object AnnotationProcessor {

}

object iOSLibraries {

}

object BackendLibraries {
    const val KtorCore = "io.ktor:ktor-server-core:${BackendVersions.KtorCore}"
    const val KtorNettyEngine = "io.ktor:ktor-server-netty:${BackendVersions.KtorCore}"
    const val LogBack = "ch.qos.logback:logback-classic:${BackendVersions.Logback}"
}
