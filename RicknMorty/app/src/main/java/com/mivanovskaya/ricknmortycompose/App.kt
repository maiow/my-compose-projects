package com.mivanovskaya.ricknmortycompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    /**excessive for Hilt, needed in Dagger-only app*/
//    lateinit var appComponent: AppComponent
//        private set
//
//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.create()
//    }
//}
//
//val Context.appComponent: AppComponent
//    get() = when (this) {
//        is App -> appComponent
//        else -> applicationContext.appComponent
    }