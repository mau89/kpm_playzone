plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
                api(project(":common:games:api"))
                implementation(project(":common:core"))
            }
        }
    }


android.namespace = "com.example.kmp_playzone.common.games.data"