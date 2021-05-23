package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.model.ParameterData

class FirstPartFragmentViewModel : ViewModel() {
    val getParameters = MutableLiveData<List<ParameterData>>()


    fun getParameters() {
        val parameter1 = ParameterData("111","3232","3232","322323")

        val parameterList = arrayListOf<ParameterData>(parameter1)

        getParameters.value = parameterList
    }

}