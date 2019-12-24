package com.example.karoltestingtraining.domain.somedomain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList


class CalculatorViewModel : ViewModel() {

    val actualFruitList: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    private val fruitsStringList: MutableList<String> = ArrayList<String>()
        .apply {
            add("Mango")
            add("Apple")
            add("Orange")
            add("Banana")
            add("Grapes")
        }

    fun simplePassthroughMethod(firstNumber: Int, secondNumber: Int): Int {
        val result = firstNumber + secondNumber
        System.out.println("${firstNumber} + ${secondNumber} = ${result}")
        return result
    }

    fun randomizeFruitsList() {
        actualFruitList.setValue(
            fruitsStringList.apply { shuffle(Random(System.nanoTime())) }
        )
    }

}

