@file:Suppress("UnstableApiUsage")

import org.mjdev.gradle.MainAppPlugin.Companion.javaVersion
import org.mjdev.gradle.MainAppPlugin.Companion.kotlinCompilerExtVersion
import org.mjdev.gradle.MainAppPlugin.Companion.loadKeyStoreProperties
import org.mjdev.gradle.MainAppPlugin.Companion.versionCode
import org.mjdev.gradle.MainAppPlugin.Companion.versionName

@Suppress("PropertyName")
val CONFIG_KEYSTORE_PROPERTIES_FILE = "config/keystore.properties"

@Suppress("PropertyName")
val SIGNING_CONFIG_NAME = "Any"

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.dokka") version "1.8.10"
    id("MainAppPlugin")
}

android {
    signingConfigs {

        loadKeyStoreProperties(
            CONFIG_KEYSTORE_PROPERTIES_FILE
        ) { aliasKey, passwordKey, fileStore, passwordStore ->
            create(SIGNING_CONFIG_NAME) {
                keyAlias = aliasKey
                keyPassword = passwordKey
                storeFile = fileStore
                storePassword = passwordStore
            }
        }
    }

    namespace = "org.mjdev.balldontlie"
    compileSdk = 33

    defaultConfig {

        applicationId = "org.mjdev.balldontlie"

        minSdk = 21
        targetSdk = 33

        versionCode = project.versionCode
        versionName = project.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        signingConfig = signingConfigs[SIGNING_CONFIG_NAME]

        // custom fields
        buildConfigField("String", "API_URL", "\"https://www.balldontlie.io/api/v1/\"")
        resValue("string", "API_URL", "https://www.balldontlie.io/api/v1/")

        buildConfigField("Boolean", "USE_MOCK", "false")

        buildConfigField("String", "SYNC_AUTH", "\"$applicationId.sync\"")
        resValue("string", "sync_auth", "$applicationId.sync")

    }

    buildTypes {

        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        release {
            isDebuggable = false
            // todo proguard
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        create("mock") {
            applicationIdSuffix = ".mock"
            isDebuggable = true
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            buildConfigField("Boolean", "USE_MOCK", "true")
        }

        create("minified") {
            applicationIdSuffix = ".min"
            isDebuggable = true
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = kotlinCompilerExtVersion
    }

    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }

    lint {
        checkReleaseBuilds = false
    }

    subprojects {
        apply(plugin = "org.jetbrains.dokka")
    }

    tasks.dokkaGfm {
        outputDirectory.set(File(projectDir, "../wiki/documentation"))
    }

}