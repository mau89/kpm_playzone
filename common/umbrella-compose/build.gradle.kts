plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}


android {
    namespace ="com.example.kmp_playzone.umbrella.compose"
}

kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))
            }
        }
    }
}