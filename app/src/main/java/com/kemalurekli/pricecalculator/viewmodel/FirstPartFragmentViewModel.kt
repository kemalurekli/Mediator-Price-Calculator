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

    fun calculateFirstPart (timeInput : Int, firstSpinnerPosition : Int, secondSpinnerPosition : Int) : Int{
        when(firstSpinnerPosition) {
            0 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=340
                    1 -> priceOffirstPart=360
                    2 -> priceOffirstPart=380
                    3 -> priceOffirstPart=400
                }
            }
            1 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=660
                    1 -> priceOffirstPart=680
                    2 -> priceOffirstPart=700
                    3 -> priceOffirstPart=720
                }
            }
            2 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=340
                    1 -> priceOffirstPart=360
                    2 -> priceOffirstPart=380
                    3 -> priceOffirstPart=400
                }
            }
            3 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=340
                    1 -> priceOffirstPart=360
                    2 -> priceOffirstPart=380
                    3 -> priceOffirstPart=400
                }
            }
            4 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=410
                    1 -> priceOffirstPart=430
                    2 -> priceOffirstPart=450
                    3 -> priceOffirstPart=470
                }
            }
            else -> priceOffirstPart=0
        }
        return timeInput * priceOffirstPart
    }
}