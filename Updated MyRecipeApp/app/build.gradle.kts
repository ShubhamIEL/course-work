plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize")
    id("kotlin-kapt") // Add kapt
    id("com.google.dagger.hilt.android") // Add Hilt
    id("org.jetbrains.kotlin.plugin.serialization") // Add Serialization
}

android {
    namespace = "com.example.myrecipeapp"
    compileSdk = 36
    kapt {
        correctErrorTypes = true
    }
    defaultConfig {
        applicationId = "com.example.myrecipeapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "META-INF/io.netty.versions.properties"
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
            excludes += "META-INF/LICENSE"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/license.txt"
            excludes += "META-INF/NOTICE"
            excludes += "META-INF/NOTICE.txt"
            excludes += "META-INF/notice.txt"
            excludes += "META-INF/INDEX.LIST"
        }
    }
}

dependencies {
    // Hilt for Dependency Injection
    implementation("com.google.dagger:hilt-android:2.57")
    implementation(libs.firebase.appdistribution.gradle)
    kapt("com.google.dagger:hilt-compiler:2.57")

    // ViewModel support for Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Lifecycle-aware collection of StateFlow
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.2")

    // Type-safe Navigation for Compose
    implementation(libs.androidx.navigation.compose)

    // Kotlinx Serialization library
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    //Compose Viewmodel
    implementation("androidx.navigation:navigation-compose:2.9.3")
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("io.coil-kt:coil-compose:2.7.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}