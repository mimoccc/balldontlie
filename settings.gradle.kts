pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://www.jitpack.io")
        @Suppress("JcenterRepositoryObsolete", "DEPRECATION")
        jcenter()
    }
}

plugins {
    id("com.gradle.enterprise") version ("3.13.3")
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
        maven(url = "https://plugins.gradle.org/m2/")
        gradlePluginPortal()
        @Suppress("JcenterRepositoryObsolete", "DEPRECATION")
        jcenter()
    }
}
gradleEnterprise {
    if (System.getenv("CI") != null) {
        buildScan {
            publishAlways()
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
    }
}
rootProject.name = "BallDontLie"
include(":app")
