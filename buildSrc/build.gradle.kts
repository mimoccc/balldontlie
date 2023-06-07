repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://www.jitpack.io")
    maven(url = "https://plugins.gradle.org/m2/")
    gradlePluginPortal()
}

plugins {
    `kotlin-dsl`
}

dependencies {
}

gradlePlugin {
    plugins {
        create("MainAppPlugin") {
            id = "MainAppPlugin"
            implementationClass = "org.mjdev.gradle.MainAppPlugin"
        }
    }
}