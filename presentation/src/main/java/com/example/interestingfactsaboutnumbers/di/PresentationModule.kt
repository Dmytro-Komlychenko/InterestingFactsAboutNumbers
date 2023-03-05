package com.example.interestingfactsaboutnumbers.di

import com.example.domain.usecase.GetFactByNumberUseCase
import com.example.domain.usecase.GetRandomFactUseCase
import com.example.interestingfactsaboutnumbers.presentation.getnumber.NumberViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideNumberViewModelFactory(
        getFactByNumberUseCase: GetFactByNumberUseCase,
        getRandomFactUseCase: GetRandomFactUseCase,
    ): NumberViewModelFactory {
        return NumberViewModelFactory(
            getFactByNumberUseCase = getFactByNumberUseCase,
            getRandomFactUseCase = getRandomFactUseCase,
        )
    }
}