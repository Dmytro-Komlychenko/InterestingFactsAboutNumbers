package com.example.interestingfactsaboutnumbers.di

import com.example.domain.usecase.GetFactByNumberUseCase
import com.example.domain.usecase.GetRandomFactUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetFactByNumberUseCase(): GetFactByNumberUseCase {
        return GetFactByNumberUseCase()
    }

    @Provides
    fun provideGetRandomFactNumberUseCase(): GetRandomFactUseCase {
        return GetRandomFactUseCase()
    }
}