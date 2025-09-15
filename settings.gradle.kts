enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { setUrl ("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap" )}
        maven { setUrl ("https://jitpack.io" )}

    }
}

rootProject.name = "DailyPulse"
include(":androidApp")
include(":shared")