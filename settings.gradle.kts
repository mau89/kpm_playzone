pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "kmp_playzone"
include(":androidApp")
include(":shared")
include(":common:auth:api")
include(":common:auth:presentation")
include(":common:auth:data")
include(":common:tournaments:api")
include(":common:tournaments:presentation")
include(":common:tournaments:data")
include(":common:games:api")
include(":common:games:presentation")
include(":common:games:data")
include(":common:core")
include(":common:umbrella-ios")
include(":common:umbrella-compose")