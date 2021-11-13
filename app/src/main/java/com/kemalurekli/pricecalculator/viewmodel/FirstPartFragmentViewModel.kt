package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.model.ParameterForFirstPart


class FirstPartFragmentViewModel : ViewModel() {

    var priceOffirstPart = 0

    private val parameterFamily = ParameterForFirstPart("340","360","380","400")
    private val parameterCommercial = ParameterForFirstPart("660","680","700","720")
    private val parameterWork = ParameterForFirstPart(parameterFamily.firstPartData1,parameterFamily.firstPartData2,parameterFamily.firstPartData3,parameterFamily.firstPartData4)
    private val parameterConsumer = ParameterForFirstPart(parameterFamily.firstPartData1,parameterFamily.firstPartData2,parameterFamily.firstPartData3,parameterFamily.firstPartData4)
    private val parameterOther = ParameterForFirstPart("410","430","450","470")



    fun calculateFirstPart (timeInput : Int, firstSpinnerPosition : Int, secondSpinnerPosition : Int) : Int{
        when(firstSpinnerPosition) {
            0 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=parameterFamily.firstPartData1!!.toInt()
                    1 -> priceOffirstPart=parameterFamily.firstPartData2!!.toInt()
                    2 -> priceOffirstPart=parameterFamily.firstPartData3!!.toInt()
                    3 -> priceOffirstPart=parameterFamily.firstPartData4!!.toInt()
                }
            }
            1 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=parameterCommercial.firstPartData1!!.toInt()
                    1 -> priceOffirstPart=parameterCommercial.firstPartData2!!.toInt()
                    2 -> priceOffirstPart=parameterCommercial.firstPartData3!!.toInt()
                    3 -> priceOffirstPart=parameterCommercial.firstPartData4!!.toInt()
                }
            }
            2 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=parameterWork.firstPartData1!!.toInt()
                    1 -> priceOffirstPart=parameterWork.firstPartData2!!.toInt()
                    2 -> priceOffirstPart=parameterWork.firstPartData3!!.toInt()
                    3 -> priceOffirstPart=parameterWork.firstPartData4!!.toInt()
                }
            }
            3 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=parameterConsumer.firstPartData1!!.toInt()
                    1 -> priceOffirstPart=parameterConsumer.firstPartData2!!.toInt()
                    2 -> priceOffirstPart=parameterConsumer.firstPartData3!!.toInt()
                    3 -> priceOffirstPart=parameterConsumer.firstPartData4!!.toInt()
                }
            }
            4 -> {
                when (secondSpinnerPosition) {
                    0 -> priceOffirstPart=parameterOther.firstPartData1!!.toInt()
                    1 -> priceOffirstPart=parameterOther.firstPartData2!!.toInt()
                    2 -> priceOffirstPart=parameterOther.firstPartData3!!.toInt()
                    3 -> priceOffirstPart=parameterOther.firstPartData4!!.toInt()
                }
            }
            else -> priceOffirstPart=0
        }
        return timeInput * priceOffirstPart
    }
}