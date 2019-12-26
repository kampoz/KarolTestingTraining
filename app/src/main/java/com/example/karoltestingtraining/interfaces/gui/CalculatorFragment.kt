package com.example.karoltestingtraining.interfaces.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.karoltestingtraining.R.layout.calculator_fragment
import com.example.karoltestingtraining.domain.somedomain.CalculatorViewModel
import kotlinx.android.synthetic.main.calculator_fragment.view.firstNumberEditText
import kotlinx.android.synthetic.main.calculator_fragment.view.randomizeFruitsButton
import kotlinx.android.synthetic.main.calculator_fragment.view.resultListTextView
import kotlinx.android.synthetic.main.calculator_fragment.view.secondNumberEditText
import kotlinx.android.synthetic.main.calculator_fragment.view.sumButton
import kotlinx.android.synthetic.main.calculator_fragment.view.sumTextView

class CalculatorFragment() : Fragment() {

    private val fragmentInstance: Fragment = this
    private lateinit var calculatorViewModel: CalculatorViewModel

    /* HELPER FOR UNIT TESTS --- BEGIN */

    // Builder specific constructor
    private constructor(calculatorViewModel: CalculatorViewModel) : this() {
        this.calculatorViewModel = calculatorViewModel
    }

    data class Builder(
        var calculatorViewModel: CalculatorViewModel? = null
    ) {
        fun calculatorViewModel(calculatorViewModel: CalculatorViewModel) = apply { this.calculatorViewModel = calculatorViewModel }
        fun build() = CalculatorFragment().also {
            it.calculatorViewModel = this.calculatorViewModel ?: it.calculatorViewModel
        }
    }

    /* HELPER FOR UNIT TESTS --- END */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        calculatorViewModel = if (::calculatorViewModel.isInitialized) calculatorViewModel else ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        return calculator_fragment
            .let { inflater.inflate(it, container, false) }
            // CalculatorViewModel Observers
            .also { setActualFruitListObserver(it) }
            // onClickListeners
            .also { setSumButtonOnClickListener(it) }
            .also { setRandomizeFruitButtonOnClickListener(it) }
    }

    private fun setActualFruitListObserver(view: View) {
        calculatorViewModel.actualFruitList.observe(
            fragmentInstance,
            Observer<List<String>> { resultList -> view.resultListTextView.text = resultList.joinToString() }
        )
    }

    private fun setSumButtonOnClickListener(view: View) {
        view.apply {
            sumButton.setOnClickListener {
                var firstNumber: Int = firstNumberEditText.run { /*validate(text)*/ text }.toString().toInt()
                var secondNumber: Int = secondNumberEditText.run { /*validate(text)*/ text }.toString().toInt()

                sumTextView.text = calculatorViewModel.simplePassthroughMethod(firstNumber, secondNumber).toString()
            }
        }
    }

    private fun setRandomizeFruitButtonOnClickListener(view: View) {
        view.apply {
            randomizeFruitsButton.setOnClickListener {
                calculatorViewModel.randomizeFruitsList()
            }
        }
    }

}