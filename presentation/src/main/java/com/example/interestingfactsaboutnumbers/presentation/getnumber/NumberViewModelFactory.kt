package com.example.interestingfactsaboutnumbers.presentation.getnumber

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetFactByNumberUseCase
import com.example.domain.usecase.GetRandomFactUseCase

class NumberViewModelFactory(
    private val getFactByNumberUseCase: GetFactByNumberUseCase,
    private val getRandomFactUseCase: GetRandomFactUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NumberViewModel(
            getFactByNumberUseCase = getFactByNumberUseCase,
            getRandomFactUseCase = getRandomFactUseCase,
        ) as T
    }

}