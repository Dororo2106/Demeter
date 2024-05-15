package com.example.demeter.dagger

import com.example.demeter.dagger.module.MainModule
import com.example.demeter.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}