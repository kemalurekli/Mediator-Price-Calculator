package com.kemalurekli.pricecalculator.viewmodel

import android.content.Context
import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.lifecycle.ViewModel
import com.kemalurekli.pricecalculator.R
import com.kemalurekli.pricecalculator.model.ParameterForFirstPart
import com.kemalurekli.pricecalculator.model.ParameterForSecondPart

class SecondPartDetailsFragmentViewModel : ViewModel(){

    private val parameterSingle = ParameterForSecondPart("6","5","4","3","2","1.5","1","0.5")
    private val parameterDouble = ParameterForSecondPart("9","7.5","6","4.5","3","2.5","1.5","1")


    fun minPriceCheck(result: Double,selection3: Int,selection4: Int) : Double {
        var finalResult : Double = result
        var minResult = 0.0
        when(selection3){
            0->{
                when(selection4){
                    0-> minResult = 680.0
                    1-> minResult = 720.0
                    2-> minResult = 760.0
                    3-> minResult = 800.0
                }
            }
            1-> {
                when(selection4){
                    0-> minResult = 1320.0
                    1-> minResult = 1360.0
                    2-> minResult = 1400.0
                    3-> minResult = 1440.0
                }
            }
        }
        if (result<minResult){
            finalResult  = minResult
        }
        return finalResult
    }

    fun calculate50  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int): Double{
        var Result = 0.0
        when(selection1){
                0->{
                    Result = (userInput*(parameterSingle.secondPartData50).toDouble()/100)
                    if (userInput>50000){
                        Result = 3000.0
                    }
                }
                1->{
                    Result = (userInput*(parameterDouble.secondPartData50).toDouble()/100)
                    if (userInput>50000){
                        Result = 4500.0
                    }
                }
        }
        Result = minPriceCheck(Result,selection3,selection4)
        return Result
    }
    fun calculate80  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>50000){
        when(selection1){
            0-> {
                Result = ((userInput-50000)*(parameterSingle.secondPartData80).toDouble()/100)
                if (userInput>130000){
                    Result = 4000.0
                }
            }
            1->{
                Result = ((userInput-50000)*(parameterDouble.secondPartData80).toDouble()/100)
                if (userInput>130000){
                    Result = 6000.0
                }
            }
        }
        }
        return Result
    }
    fun calculate130  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>130000){
        when(selection1){
            0-> {
                Result = ((userInput-130000)*(parameterSingle.secondPartData130).toDouble()/100)
                if (userInput>260000){
                    Result = 5200.0
                }
            }
            1->{
                Result = ((userInput-130000)*(parameterDouble.secondPartData130).toDouble()/100)
                if (userInput>260000){
                    Result = 7800.0
                }
            }
        }
        }
        return Result
    }
    fun calculate260  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>260000){
        when(selection1){
            0-> {
                Result = ((userInput-260000)*(parameterSingle.secondPartData260).toDouble()/100)
                if (userInput>520000){
                    Result = 7800.0
                }
            }
            1->{
                Result = ((userInput-260000)*(parameterDouble.secondPartData260).toDouble()/100)
                if (userInput>520000){
                    Result = 11700.0
                }
            }
        }
        }
        return Result
    }
    fun calculate780  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>520000){
        when(selection1){
            0-> {
                Result = ((userInput-520000)*(parameterSingle.secondPartData780).toDouble()/100)
                if (userInput>1300000){
                    Result = 15600.0
                }
            }
            1->{
                Result = ((userInput-520000)*(parameterDouble.secondPartData780).toDouble()/100)
                if (userInput>1300000){
                    Result = 23400.0
                }
            }
        }
        }
        return Result
    }
    fun calculate1040  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>1300000){
        when(selection1){
            0-> {
                Result = ((userInput-1300000)*(parameterSingle.secondPartData1040).toDouble()/100)
                if (userInput>2340000){
                    Result = 15600.0
                }
            }
            1->{
                Result = ((userInput-1300000)*(parameterDouble.secondPartData1040).toDouble()/100)
                if (userInput>2340000){
                    Result = 26000.0
                }
            }
        }
        }
        return Result
    }
    fun calculate2080  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>2340000){
        when(selection1){
            0-> {
                Result = ((userInput-2340000)*(parameterSingle.secondPartData2080).toDouble()/100)
                if (userInput>4420000){
                    Result = 20800.0
                }
            }
            1->{
                Result = ((userInput-2340000)*(parameterDouble.secondPartData2080).toDouble()/100)
                if (userInput>4420000){
                    Result = 31200.0
                }
            }
        }
        }
        return Result
    }
    fun calculate4160  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{
        var Result = 0.0
        if (userInput>4420000){
        when(selection1){
            0-> {
                Result = ((userInput-4420000)*(parameterSingle.secondPartData4160).toDouble()/100)
            }
            1->{
                Result = ((userInput-4420000)*(parameterDouble.secondPartData4160).toDouble()/100)
            }
        }
        }
        return Result
    }
    fun calculateTotal  (userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): Double{

        return  calculate50(userInput,selection1,selection2,selection3,selection4)+
                calculate80(userInput,selection1,selection2,selection3,selection4)+
                calculate130(userInput,selection1,selection2,selection3,selection4)+
                calculate260(userInput,selection1,selection2,selection3,selection4)+
                calculate780(userInput,selection1,selection2,selection3,selection4)+
                calculate1040(userInput,selection1,selection2,selection3,selection4)+
                calculate2080(userInput,selection1,selection2,selection3,selection4)+
                calculate4160(userInput,selection1,selection2,selection3,selection4)
    }

    fun setExplanation(userInput : Double, selection1 : Int,  selection2 : Int, selection3: Int, selection4: Int ): String{

        var mediatorNumber = ""
        var caseType = ""
        var counterpartyNumber = ""
        when(selection1){
            0-> mediatorNumber = "Bir arabulucu görev yaptığı, "
            1-> mediatorNumber = "Birden fazla arabulucu görev yaptığı, "
        }
        when(selection3){
            0-> caseType = "İş / Tüketici Hukuku Uyuşmazlığında, "
            1-> caseType = "Ticari Uyuşmazlıkta, "
        }
        when(selection4){
            0-> counterpartyNumber = "2 taraflı işlerde "
            1-> counterpartyNumber = "3-5 taraflı işlerde "
            2-> counterpartyNumber = "6-10 taraflı işlerde "
            3-> counterpartyNumber = "11 ve daha fazla taraflı işlerde "
        }

        return userInput.toString() + "₺ Tutarlı " + mediatorNumber + caseType + counterpartyNumber
    }

}