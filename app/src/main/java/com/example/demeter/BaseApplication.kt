package com.example.demeter

import android.app.Application
import com.example.demeter.dagger.AppComponent

class BaseApplication : Application() {
    init {
        INSTANCE = this
    }

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
    }



    companion object{
        lateinit var INSTANCE: BaseApplication
    }
}