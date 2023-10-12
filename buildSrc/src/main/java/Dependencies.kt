object Versions {
    const val coreKtx = "1.9.0"
    const val lifecycleRumtime = "2.6.2"

    const val activityCompose = "1.8.0"
    const val composeBom = "2023.03.00"
    const val composeNavigation = "2.5.3"

    const val materialIcon = "1.0.2"

    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"

    const val accompanistSystemUiController = "0.28.0"

    const val daggerHilt = "2.44.2"
    const val hiltCompiler = "1.0.0"
    const val hiltNavigation = "1.0.0"

    const val retrofit = "2.9.0"
    const val logginInterceptor = "5.0.0-alpha.6"

    const val pagination = "3.2.1"

    const val room = "2.5.2"

    const val coil = "2.4.0"

    const val shimmer = "1.0.3"
}

object Libraries {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRumtime}"

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"

    const val materialIcon = "androidx.compose.material:material-icons-extended:${Versions.materialIcon}"

    const val accompanistSystemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistSystemUiController}"

    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logginInterceptor}"

    const val pagination = "androidx.paging:paging-runtime:${Versions.pagination}"
    const val paginationCompose = "androidx.paging:paging-compose${Versions.pagination}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    const val shimmer = "com.valentinilk.shimmer:compose-shimmer:${Versions.shimmer}"
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