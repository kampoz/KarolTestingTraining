package com.example.karoltestingtraining

import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario

//import androidx.fragment.app.testing.FragmentScenario

import com.example.karoltestingtraining.domain.somedomain.CalculatorViewModel
import com.example.karoltestingtraining.interfaces.gui.CalculatorFragment
import org.junit.Test

//import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith

//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.junit.runner.RunWith

//import androidx.test.ext.junit.runners.AndroidJUnit4
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import spock.lang.Specification

//import static androidx.fragment.app.testing.FragmentScenario.launch

import static com.example.karoltestingtraining.R.id.sumButton

//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.runner.AndroidJUnitRunner

@RunWith(RobolectricTestRunner.class)
//@ExtendWith(AndroidJUnit4.class)
//@ExtendWith(RobolectricTestRunner.class)
//@RunWith(AndroidJUnit4.class)
//@Config(sdk = VERSION_CODES.O_MR1)
@Config(sdk = VERSION_CODES.P)
//@Config(sdk = VERSION_CODES.Q)
//class FirstSpec{
class FirstSpec extends Specification {

//    @Subject
    // Set View based on calculator_fragment
//    View view =  CalculatorFragment //GroovySpy(View)

    @Test
    void "asd"() {
        given:
//            1 == 1
//        given:
            def calculatorViewModel = Spy(CalculatorViewModel)

            def bundle = new Bundle()
            bundle.putParcelable("calculatorViewModel", calculatorViewModel)

        when:
            FragmentScenario calculatorFragmentScenario = FragmentScenario.launch(CalculatorFragment, bundle)
//            calculatorFragmentScenario.toString()
//            fragmentScenario.setCalculatorViewModel(calculatorViewModel)
            calculatorFragmentScenario.onFragment({ fragment ->
                println("before click")
                fragment.getView().findViewById(sumButton).performClick()
                println("after click")
            })

//        Builder.setCalculatorViewModel(viewModel).build()
//            def calculatorViewModel = new CalculatorViewModel()

//            def calculatorFragment = new CalculatorFragment(calculatorViewModel)

//            FragmentManager fragmentManager = FragmentController
//                    .createController(new HostCallbacks())
//                    .getSupportFragmentManager()
//
//        fragmentManager.getLayoutInflaterFactory()

//            fragmentManagera.beginTransaction()
//                    .add(R.id.fragment_container, calculatorFragment)
//                    .commit()

//            fragmentManager.getLayou

//        when:
//            def setSumButtonOnClickListener = calculatorFragment.setSumButtonOnClickListener(view)

        then:
//            1 * calculatorViewModel.actualFruitList()
//            1 * calculatorViewModel.simplePassthroughMethod(_ as Integer,_ as Integer)
//        true
            0 * _
    }


//    abstract class CalculatorViewModelParceleable extends CalculatorViewModel implements Parcelable{}
}