plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = AndroidConfig.id
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.id
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidConfig.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libraries.coreKtx)
    implementation(Libraries.lifecycleRuntime)

    //compose
    implementation(Libraries.activityCompose)
    implementation(platform(Libraries.composeBom))
    implementation(Libraries.composeUi)
    implementation(Libraries.composeUiGraphics)
    implementation(Libraries.composeUiPreview)
    implementation(Libraries.composeMaterial3)
    implementation(Libraries.composeNavigation)

    //accompanist
    implementation(Libraries.accompanistSystemUiController)


    //test
    testImplementation(TestLibraries.junit)
    androidTestImplementation(AndroidTestLibraries.extJunit)
    androidTestImplementation(AndroidTestLibraries.espressoCore)
    androidTestImplementation(platform(AndroidTestLibraries.composeBom))
    androidTestImplementation(AndroidTestLibraries.composeJunit)

    //debug
    debugImplementation(Debug.composeUiTooling)
    debugImplementation(Debug.composeUiTestManifest)
}