plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

android.namespace = "com.example.kmp_playzone.common.games.api"
kotlin {
    sourceSets {
        commonMain.dependencies {
                implementation(libs.kotlinx.serialization.core)
            }
        }
    }