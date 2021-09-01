package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.model.ParameterData
import com.kemalurekli.pricecalculator.view.FirstPartFragment


class FirstPartFragmentViewModel : ViewModel() {
    val getParameters = MutableLiveData<List<ParameterData>>()


    fun getParameters() {
        val parameter1 = ParameterData("111","3232","3232","322323")
        val parameterList = arrayListOf<ParameterData>(parameter1)
        getParameters.value = parameterList
    }

    fun CalculateFirstPart (timeInput : Int, firstSpinnerPosition : Int, secondSpinnerPosition : Int){
        println("hesaplama gerçekleşti.")
        println("Girilen değer : $timeInput")
        println("İlk Spinner :  $firstSpinnerPosition")
        println("İkinci Spinner : $secondSpinnerPosition")
    }


}