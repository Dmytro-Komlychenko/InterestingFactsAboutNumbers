package com.example.interestingfactsaboutnumbers.presentation.number

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

    var factAboutNumber: MutableLiveData<FactAboutNumber> = MutableLiveData()

    fun getFact(number: Int) {
        viewModelScope.launch {
            factAboutNumber.value = FactAboutNumber(number, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper purus sed libero iaculis ultrices. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a eros sapien. Pellentesque non convallis odio, id luctus odio. Proin rutrum ultricies arcu sollicitudin lobortis. Sed pharetra erat mi, ut faucibus nisl bibendum id. Integer tristique diam sed enim congue, in sodales libero malesuada. Donec tincidunt volutpat tellus vel porttitor.")
            // factAboutNumber.value = getFactByNumberUseCase.execute(number)
        }
    }

    fun getRandomFact() {
        viewModelScope.launch {
            factAboutNumber.value = FactAboutNumber(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis semper purus sed libero iaculis ultrices. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin a eros sapien. Pellentesque non convallis odio, id luctus odio. Proin rutrum ultricies arcu sollicitudin lobortis. Sed pharetra erat mi, ut faucibus nisl bibendum id. Integer tristique diam sed enim congue, in sodales libero malesuada. Donec tincidunt volutpat tellus vel porttitor.")
            // factAboutNumber.value = getRandomFactUseCase.execute()
        }
    }
}