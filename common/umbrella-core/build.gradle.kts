plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:core-utils"))

                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))

//                implementation(Dependencies.Kodein.core)
            }
        }
    }
}

android.namespace ="com.example.kmp_playzone.common.umbrella.core"