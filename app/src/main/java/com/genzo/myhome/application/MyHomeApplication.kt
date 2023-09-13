package com.genzo.myhome.application

import android.app.Application
import com.genzo.myhome.di.AppContainer

class MyHomeApplication : Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(applicationContext = applicationContext)
    }
}
