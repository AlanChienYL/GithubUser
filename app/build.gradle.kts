plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Android.compileSdkVersion)
    defaultConfig {
        applicationId = "com.alan.githubuser"
        minSdkVersion(Versions.Android.minSdkVersion)
        targetSdkVersion(Versions.Android.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName(BuildTypes.Release.name) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.core:core-ktx:${Versions.Android.coreKtx}")
    implementation("androidx.appcompat:appcompat:${Versions.Android.appCompat}")
    implementation("com.google.android.material:material:${Versions.Android.material}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.Android.constraintLayout}")

    androidTestImplementation("androidx.test.ext:junit:${Versions.Test.junit}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.Test.espresso}")
}
