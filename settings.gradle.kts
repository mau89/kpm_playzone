pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "kmp_playzone"
include(":composeApp")
include(":desktop")
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:auth:compose")
include(":common:main:api")
include(":common:main:presentation")
include(":common:main:compose")
include(":common:main:data")
include(":common:tournaments:data")
include(":common:games:api")
include(":common:games:data")
include(":common:core")
include(":common:core-compose")
include(":common:core-utils")
include(":common:umbrella-ios")
include(":common:umbrella-compose")
include(":common:umbrella-core")