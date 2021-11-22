package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.model.ParameterForFirstPart
import com.kemalurekli.pricecalculator.model.ParameterForSecondPart

class SecondPartDetailsFragmentViewModel : ViewModel(){

    private val parameterSingle = ParameterForSecondPart("6","5","4","3","2","1.5","1","0.5")
    private val parameterDouble = ParameterForSecondPart("9","7.5","6","4.5","3","2.5","1.5","1")






    fun minPriceCheck(minSingleResult : Double, result : Double, mediatorNumber: Int) : Double{
        var finalResult : Double = result
        if (result<minSingleResult){
            finalResult  = minSingleResult
        }
        return finalResult
    }



    fun calculate50  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

                0-> {
                    Result = (price*(parameterSingle.secondPartData50).toDouble()/100)
                }
                1->{
                    Result = (price*(parameterDouble.secondPartData50).toDouble()/100)
                }
        }
        when(counterparty){
            0-> Result = minPriceCheck(680.0,Result,mediatorNumber)
            1-> Result = minPriceCheck(720.0,Result,mediatorNumber)
            2-> Result = minPriceCheck(760.0,Result,mediatorNumber)
            3-> Result = minPriceCheck(800.0,Result,mediatorNumber)
        }

        return Result
    }
    fun calculate80  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData80).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData80).toDouble()/100)
            }
        }
        when(counterparty){
            0-> Result = minPriceCheck(680.0,Result,mediatorNumber)
            1-> Result = minPriceCheck(720.0,Result,mediatorNumber)
            2-> Result = minPriceCheck(760.0,Result,mediatorNumber)
            3-> Result = minPriceCheck(800.0,Result,mediatorNumber)
        }
        return Result
    }
    fun calculate130  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData130).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData130).toDouble()/100)
            }
        }
        return Result
    }
    fun calculate260  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData260).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData260).toDouble()/100)
            }
        }
        return Result
    }
    fun calculate780  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData780).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData780).toDouble()/100)
            }
        }
        return Result
    }
    fun calculate1040  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData1040).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData1040).toDouble()/100)
            }
        }
        return Result
    }
    fun calculate2080  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData2080).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData2080).toDouble()/100)
            }
        }
        return Result
    }
    fun calculate4160  (price : Double, mediatorNumber : Int, counterparty : Int ): Double{
        var Result = 0.0
        when(mediatorNumber){

            0-> {
                Result = (price*(parameterSingle.secondPartData4160).toDouble()/100)
            }
            1->{
                Result = (price*(parameterDouble.secondPartData4160).toDouble()/100)
            }
        }
        return Result
    }
    fun calculateTotal  (price : Double): String{
        val Result : String = (price*(parameterSingle.secondPartData50).toDouble()/100).toString()
        return "$Result ₺"
    }

}