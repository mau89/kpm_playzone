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
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))

                implementation(Dependencies.Other.ViewModel.odyssey)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.core)

                implementation(Dependencies.Other.Navigation.compose)
                implementation(Dependencies.Other.Navigation.core)
            }
        }

        androidMain{
            dependencies{
                implementation(project(":common:core-compose"))
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}