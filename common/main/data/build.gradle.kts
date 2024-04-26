plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
                implementation(project(":common:auth:api"))
                implementation(project(":common:core"))

//                implementation(Dependencies.Kodein.core)
//                implementation(Dependencies.Settings.core)
            }
        }
    }


android.namespace = "com.example.kmp_playzone.common.main.data"