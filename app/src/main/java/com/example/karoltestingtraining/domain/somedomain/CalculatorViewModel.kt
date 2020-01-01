package com.example.karoltestingtraining.domain.somedomain

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList


open class CalculatorViewModel() : ViewModel(), Parcelable {

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

    constructor(parcel: Parcel) : this() {
        parcel.toString()
    }

    fun simplePassthroughMethod(firstNumber: Int, secondNumber: Int): Int {
        val result = firstNumber + secondNumber
        println("${firstNumber} + ${secondNumber} = ${result}")
        return result
    }

    fun randomizeFruitsList() {
        actualFruitList.setValue(
            fruitsStringList.apply { shuffle(Random(System.nanoTime())) }
        )
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CalculatorViewModel> {
        override fun createFromParcel(parcel: Parcel): CalculatorViewModel {
            return CalculatorViewModel(parcel)
        }

        override fun newArray(size: Int): Array<CalculatorViewModel?> {
            return arrayOfNulls(size)
        }
    }

}

