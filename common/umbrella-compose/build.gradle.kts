plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:compose"))
                implementation(project(":common:auth:data"))

                implementation(project(":common:core"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))

                implementation(project(":common:games:data"))

                implementation(project(":common:main:compose"))

                implementation(libs.kviewmodel.core)
                implementation(libs.kviewmodel.compose)
                implementation(libs.kviewmodel.odyssey)

                implementation(libs.odyssey.compose)
                implementation(libs.odyssey.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.activity.compose)
            }
        }
    }
}

android.namespace = "com.example.kmp_playzone.common.umbrella_compose"