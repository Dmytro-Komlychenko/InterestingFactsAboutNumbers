package com.example.interestingfactsaboutnumbers.presentation.getnumber

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetFactByNumberUseCase
import com.example.domain.usecase.GetRandomFactUseCase
import com.example.interestingfactsaboutnumbers.model.FactAboutNumber
import kotlinx.coroutines.launch

class NumberViewModel(
    private val getFactByNumberUseCase: GetFactByNumberUseCase,
    private val getRandomFactUseCase: GetRandomFactUseCase
) : ViewModel() {

    val factAboutNumber: MutableLiveData<FactAboutNumber> = MutableLiveData()

    fun getFact(number: Int) {
        viewModelScope.launch {
            // factAboutNumber = getFactByNumberUseCase.execute(number)
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            // factAboutNumber = getRandomFactUseCase.execute()
        }
    }
}