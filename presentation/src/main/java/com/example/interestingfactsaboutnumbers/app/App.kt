package com.example.interestingfactsaboutnumbers.app

import android.app.Application
import com.example.interestingfactsaboutnumbers.di.AppComponent
import com.example.interestingfactsaboutnumbers.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}