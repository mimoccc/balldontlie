@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.util.Properties
import kotlin.text.toInt

@Suppress("PropertyName")
val CONFIG_VERSION_PROPERTIES_FILE = "config/version.properties"
@Suppress("PropertyName")
val CONFIG_KEYSTORE_PROPERTIES_FILE = "config/keystore.properties"

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.dokka") version "1.8.10"
//    id("com.akaita.android.easylauncher")
//    id("androidx.navigation.safeargs.kotlin")
//    id("kotlinx-serialization")
//    id("io.gitlab.arturbosch.detekt")
}

android {

    signingConfigs {

        val keystorePropertiesFile = rootProject.file(CONFIG_KEYSTORE_PROPERTIES_FILE)
        val keystoreProperties = Properties()

        if (keystorePropertiesFile.exists()) {
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))
        } else {
            keystoreProperties["keyAlias"] = System.getenv("KEYSTORE_KEY_ALIAS").orEmpty()
            keystoreProperties["keyPassword"] = System.getenv("KEYSTORE_KEY_PASSWORD").orEmpty()
            keystoreProperties["storePassword"] = System.getenv("KEYSTORE_STORE_PASSWORD").orEmpty()
            keystoreProperties["storeFile"] = System.getenv("KEYSTORE_FILE").orEmpty()
        }

        create("any") {
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = File(projectDir, keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }

    }

    val versionPropertiesFile = rootProject.file(CONFIG_VERSION_PROPERTIES_FILE)
    val versionProps = Properties()
    versionProps.load(FileInputStream(versionPropertiesFile))
    versionProps.forEach { prop ->
        rootProject.ext.set(prop.key.toString(), prop.value.toString())
    }

    fun getVersionCode(): Int {
        val major = rootProject.ext.get("majorVersion")?.toString()?.toInt() ?: 1
        val minor = rootProject.ext.get("minorVersion")?.toString()?.toInt() ?: 0
        val patch = rootProject.ext.get("patchVersion")?.toString()?.toInt() ?: 0
        return major * 10000 + minor * 100 + patch
    }

    fun getVersionName(): String {
        val major = rootProject.ext.get("majorVersion")?.toString()?.toInt() ?: 1
        val minor = rootProject.ext.get("minorVersion")?.toString()?.toInt() ?: 0
        val patch = rootProject.ext.get("patchVersion")?.toString()?.toInt() ?: 0
        return "${major}.${minor}.${patch}"
    }

    namespace = "org.mjdev.balldontlie"
    compileSdk = 33

    defaultConfig {

        applicationId = "org.mjdev.balldontlie"

        minSdk = 21
        targetSdk = 33

        versionCode = getVersionCode()
        versionName = getVersionName()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        signingConfig = signingConfigs["any"]

        // custom fields
        buildConfigField("String", "API_URL", "\"https://www.balldontlie.io/api/v1/\"")
        resValue("string", "API_URL", "https://www.balldontlie.io/api/v1/")

        buildConfigField("Boolean", "USE_MOCK", "false")

        buildConfigField("String", "SYNC_AUTH", "\"" + applicationId + ".sync\"")
        resValue("string", "sync_auth", applicationId + ".sync")

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
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

    tasks.register("prepareReleaseNotes") {
        doLast {
            exec {
                workingDir(rootDir)
                args(getVersionName())
                executable("./scripts/git_log.sh")
            }
        }
    }

    afterEvaluate {
        // all versions release notes
        tasks.findByName("assembleDebug")?.finalizedBy("prepareReleaseNotes")
        tasks.findByName("assembleMock")?.finalizedBy("prepareReleaseNotes")
        tasks.findByName("assembleMinified")?.finalizedBy("prepareReleaseNotes")
        tasks.findByName("assembleRelease")?.finalizedBy("prepareReleaseNotes")

        // dokka documentation generation
        tasks.findByName("prepareReleaseNotes")?.finalizedBy("dokkaGfm")
    }

}

dependencies {
    // dependency on local binaries
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    // base, kotlin & etc
    implementation("androidx.core:core-ktx:1.10.1")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.7.0"))
    // lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    // dagger core
    implementation("com.google.dagger:dagger:2.46.1")
    kapt("com.google.dagger:dagger-compiler:2.46.1")
    // dagger android
    implementation("com.google.dagger:dagger-android:2.46.1")
    implementation("com.google.dagger:dagger-android-support:2.46.1")
    kapt("com.google.dagger:dagger-android-processor:2.46.1")
    // dagger - hilt
    implementation("com.google.dagger:hilt-android:2.46.1")
    kapt("com.google.dagger:hilt-compiler:2.46.1")
    // themes
    implementation("com.google.android.material:material:1.9.0")
    // compose
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-graphics:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.paging:paging-compose:1.0.0-alpha20")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.paging:paging-compose:1.0.0-alpha20")
    // glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("com.github.bumptech.glide:gifdecoder:4.15.1")
    implementation("com.github.bumptech.glide:annotations:4.15.1")
    implementation("com.github.bumptech.glide:okhttp4-integration:4.15.1")
    kapt("com.github.bumptech.glide:compiler:4.15.1")
    // okhttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    // moshi
    implementation("com.squareup.moshi:moshi:1.15.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
    // log
    implementation("com.jakewharton.timber:timber:5.0.1")
    // db
    implementation("com.j256.ormlite.cipher:ormlite-sqlcipher:1.4@aar")
    implementation("com.j256.ormlite:ormlite-core:5.1")
    implementation("com.j256.ormlite:ormlite-android:5.1")
    implementation("net.zetetic:android-database-sqlcipher:4.0.1@aar")
    // test
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.dagger:hilt-android-testing:2.46.1")
    testAnnotationProcessor("com.google.dagger:hilt-compiler:2.46.1")
    // ui test
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.05.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.3")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.46.1")
    androidTestAnnotationProcessor("com.google.dagger:hilt-compiler:2.46.1")
    // debug
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.3")
    // kotlin conf
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.7.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
    // reflection just for view models, unfinished compose libs
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.21")
}