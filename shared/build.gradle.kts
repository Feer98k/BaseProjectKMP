import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.composeCompiler)

}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // ----------------------------------------
            // Compose Multiplatform Core
            // ----------------------------------------
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // ----------------------------------------
            // Lifecycle / ViewModel (Multiplatform)
            // ----------------------------------------
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // ----------------------------------------
            // Networking (Ktor)
            // ----------------------------------------
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            // ----------------------------------------
            // MVVM (Moko)
            // ----------------------------------------
            implementation(libs.moko.mvvm.core)
            implementation(libs.moko.mvvm.compose)

            // ----------------------------------------
            // Image loading (Kamel)
            // ----------------------------------------
            implementation(libs.kamel)

            // ----------------------------------------
            // Dependency Injection (Koin)
            // ----------------------------------------
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeVM)

            // ----------------------------------------
            // Kotlin Utils
            // ----------------------------------------
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kotlinx.serialization.json)

            // ----------------------------------------
            // Navegação
            // ----------------------------------------
            implementation(libs.uri.kmp)
            implementation(libs.navigation.compose)
        }

        androidMain.dependencies {
            // ----------------------------------------
            // Compose Preview
            // ----------------------------------------
            implementation(compose.preview)

            // ----------------------------------------
            // AndroidX Activity Compose
            // ----------------------------------------
            implementation(libs.androidx.activity.compose)

            // ----------------------------------------
            // Networking (Ktor - Android)
            // ----------------------------------------
            implementation(libs.ktor.client.okhttp)

            // ----------------------------------------
            // Dependency Injection (Koin Android)
            // ----------------------------------------
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)

            // ----------------------------------------
            // Firebase
            // ----------------------------------------
            implementation(libs.firebase.bom)
            implementation(libs.firebase.config)

            // ----------------------------------------
            // Android-specific UI Extensions
            // ----------------------------------------
            implementation(libs.androidx.ui.text.android)
            implementation("androidx.datastore:datastore-preferences:1.0.0")
            implementation("androidx.datastore:datastore-core:1.0.0")
            implementation("androidx.datastore:datastore-preferences-core:1.0.0")
        }

        iosMain.dependencies {
            // ----------------------------------------
            // Networking (Ktor - iOS)
            // ----------------------------------------
            implementation(libs.ktor.client.darwin)

            // ----------------------------------------
            // Skiko (imagem e gráficos multiplataforma)
            // ----------------------------------------
            implementation(libs.skiko)
        }
    }
}

android {
    namespace = "com.f98k.tipstermindcocoapods"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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

    flavorDimensions += "env"

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false // ProGuard/desugaring OFF
        }
        getByName("release") {
            isMinifyEnabled = true // ProGuard ativo em release
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    productFlavors {
        create("dev") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "false")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "true")
            manifestPlaceholders["appLabel"] = "Tipster (DEV)"
        }

        create("devHml") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "true")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "true")
            manifestPlaceholders["appLabel"] = "Tipster (DEV-HML)"
        }

        create("prod") {
            dimension = "env"
            buildConfigField("Boolean", "ANALYTICS_ENABLED", "true")
            buildConfigField("Boolean", "IS_LOG_ENABLED", "false")
            manifestPlaceholders["appLabel"] = "Tipster"
        }
    }

}
dependencies {
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui.android)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.ui.graphics.android)
    implementation(libs.androidx.foundation.layout.android)
}
