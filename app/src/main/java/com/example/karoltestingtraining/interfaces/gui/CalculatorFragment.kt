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

class CalculatorFragment : Fragment() {

    private val fragmentInstance: Fragment = this
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        setCalculatorViewModel(ViewModelProviders.of(this).get(CalculatorViewModel::class.java))
//        this.getArguments()
        var cvm: CalculatorViewModel? = this.arguments?.getParcelable<CalculatorViewModel>("calculatorViewModel")

        setCalculatorViewModel(cvm!!)

        return calculator_fragment
            .let { inflater.inflate(it, container, false) }
            // CalculatorViewModel Observers
            .also { setActualFruitListObserver(it) }
            // onClickListeners
            .also { setSumButtonOnClickListener(it) }
            .also { setRandomizeFruitButtonOnClickListener(it) }
    }

    private fun setCalculatorViewModel(calculatorViewModel: CalculatorViewModel) {
        this.calculatorViewModel = calculatorViewModel
    }

    private fun setActualFruitListObserver(view: View) {
        view.apply{
            calculatorViewModel.actualFruitList.observe(
                fragmentInstance,
                Observer<List<String>> {
                        resultList -> resultListTextView.text = resultList.joinToString()
                }
            )
        }
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
