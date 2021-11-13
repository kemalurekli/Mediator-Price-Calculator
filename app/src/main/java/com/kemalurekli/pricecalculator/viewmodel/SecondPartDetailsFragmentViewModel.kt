package com.kemalurekli.pricecalculator.viewmodel

import androidx.lifecycle.ViewModel

class SecondPartDetailsFragmentViewModel : ViewModel(){
    //val getUserPrice : Double = arguments?.
    fun getDataFromSecondAndCalculate(Price : Double, select1 : Int, select2 : Int, select3 : Int, select4 : Int){
        println("$Price $select1 $select2 $select3 $select4")

    }
}