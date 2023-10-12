object Versions {
    const val coreKtx = "1.9.0"
    const val lifecycleRumtime = "2.6.2"

    const val activityCompose = "1.8.0"
    const val composeBom = "2023.03.00"
    const val composeNavigation = "2.5.3"

    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"

    const val accompanistSystemUiController = "0.28.0"
}

object Libraries {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRumtime}"

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistSystemUiController}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
}

object AndroidTestLibraries {
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4"
}

object Debug {
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
}