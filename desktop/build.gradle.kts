plugins{
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm{
        withJava()
    }

    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:games:api"))
                implementation(project(":common:main:compose"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:umbrella-core"))
                implementation(project(":common:umbrella-compose"))

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }
        named("jvmMain"){
            dependencies{
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
            )

            packageName = "KMP_Playzone-Admin"
            packageVersion = "1.0.0"

            windows {
                menuGroup = " KMP PlayZone Admin"
                upgradeUuid = "5e0d073f-5f09-4cc2-aaec-5c363fa3644e"
            }
        }
    }
}