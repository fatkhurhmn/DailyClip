import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.daggerHilt)
    kotlin(Plugins.kapt)
    id(Plugins.ksp)
}

val localPropertiesFile = rootProject.file("local.properties")
val localProperties = Properties()
localProperties.load(FileInputStream(localPropertiesFile))

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

        buildConfigField("String", "API_KEY", localProperties.getProperty("API_KEY"))
        buildConfigField("String", "BASE_URL_API", localProperties.getProperty("BASE_URL_API"))
        buildConfigField("String", "BASE_URL_API", localProperties.getProperty("BASE_URL_API"))
        android.buildFeatures.buildConfig = true
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

    //material icon
    implementation(Libraries.materialIcon)

    //accompanist
    implementation(Libraries.accompanistSystemUiController)

    //dagger
    implementation(Libraries.daggerHilt)
    kapt(Libraries.daggerHiltCompiler)
    kapt(Libraries.hiltCompiler)
    implementation(Libraries.hiltNavigation)

    //retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.converterGson)
    implementation(Libraries.loggingInterceptor)

    //pagination
    implementation(Libraries.pagination)
    implementation(Libraries.paginationCompose)

    //room
    implementation(Libraries.room)
    implementation(Libraries.roomKtx)
    ksp(Libraries.roomCompiler)

    //coil
    implementation(Libraries.coil)

    //shimmer
    implementation(Libraries.shimmer)

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

kapt {
    correctErrorTypes = true
}