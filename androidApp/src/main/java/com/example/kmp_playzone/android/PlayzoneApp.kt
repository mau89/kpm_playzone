package com.example.kmp_playzone.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class PlayzoneApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun PlayzoneApp.initPlatformSDK() =
    PlatformSDK.init(configuration = PlatformConfiguration(androidContext = applicationContext))