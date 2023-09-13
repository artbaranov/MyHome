package com.genzo.myhome.application

import android.app.Application
import com.genzo.myhome.di.AppContainer

class MyHomeApplication : Application() {
    val appContainer = AppContainer(applicationContext = this)
}
