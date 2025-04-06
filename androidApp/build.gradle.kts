import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.googleGmsGoogleServices)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}
kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
}

android {
    namespace = "com.f98k.baseproject.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.f98k.baseproject.android"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    sourceSets {
        getByName("main") {
            manifest.srcFile("src/main/AndroidManifest.xml")
        }
    }

    flavorDimensions += "env" // Pode ter mais de uma dimensão no futuro, como "store" ou "region"

    productFlavors {
        create("dev") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "false")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "true")
            manifestPlaceholders["appLabel"] = "BaseProject (DEV)"
        }

        create("devHml") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "true")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "true")
            manifestPlaceholders["appLabel"] = "BaseProject (DEV-HML)"
        }

        create("prod") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "true")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "false")
            manifestPlaceholders["appLabel"] = "BaseProject"
        }
    }
}

dependencies {
    // ----------------------------------------
    // Projeto compartilhado (Multiplatform)
    // ----------------------------------------
    implementation(projects.shared)

    // ----------------------------------------
    // Networking (Ktor - Android)
    // ----------------------------------------
    implementation(libs.ktor.client.okhttp)

    // ----------------------------------------
    // Dependency Injection (Koin - Android)
    // ----------------------------------------
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // ----------------------------------------
    // Jetpack Compose (Android)
    // ----------------------------------------
    implementation(libs.compose.ui.pure)
    implementation(libs.compose.foundation.pure)
    implementation(libs.compose.material.pure)
    implementation(libs.androidx.activity.compose)

    // ----------------------------------------
    // Lifecycle (Android - Compose)
    // ----------------------------------------
    implementation(libs.lifecycle.runtime.ktx.pure)
    implementation(libs.lifecycle.viewmodel.compose.pure)

    // ----------------------------------------
    // Compose Tooling (Preview)
    // ----------------------------------------
    debugImplementation(libs.compose.ui.tooling.pure)

    // ----------------------------------------
    // Firebase (Android)
    // ----------------------------------------
    implementation(libs.firebase.bom)
    implementation(libs.firebase.config)
}