package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.model.ParameterData
import com.kemalurekli.pricecalculator.view.FirstPartFragment


class FirstPartFragmentViewModel : ViewModel() {
    val getParameters = MutableLiveData<List<ParameterData>>()
    var priceOffirstPart = 0



    fun getParameters() {
        val parameter1 = ParameterData("111","3232","3232","322323")
        val parameterList = arrayListOf<ParameterData>(parameter1)
        getParameters.value = parameterList
    }

    fun CalculateFirstPart (timeInput : Int, firstSpinnerPosition : Int, secondSpinnerPosition : Int) : Int{
        when(firstSpinnerPosition) {
            0 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=360
                    1 -> priceOffirstPart=380
                    2 -> priceOffirstPart=400
                    3 -> priceOffirstPart=420

                }
            }
            1 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=460
                    1 -> priceOffirstPart=480
                    2 -> priceOffirstPart=500
                    3 -> priceOffirstPart=520

                }
            }
            2 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=460
                    1 -> priceOffirstPart=480
                    2 -> priceOffirstPart=400
                    3 -> priceOffirstPart=420

                }
            }
            3 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=360
                    1 -> priceOffirstPart=380
                    2 -> priceOffirstPart=400
                    3 -> priceOffirstPart=420

                }
            }



            else -> priceOffirstPart=0
        }
        println("hesaplama gerçekleşti.")
        println("Girilen değer : $timeInput")
        println("İlk Spinner :  $firstSpinnerPosition")
        println("İkinci Spinner : $secondSpinnerPosition")
        return timeInput * priceOffirstPart
    }


}