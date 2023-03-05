package com.example.interestingfactsaboutnumbers.di

import com.example.interestingfactsaboutnumbers.presentation.main.MainActivity
import dagger.Component

@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}