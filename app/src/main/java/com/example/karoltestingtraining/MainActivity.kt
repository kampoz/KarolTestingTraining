package com.example.karoltestingtraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.karoltestingtraining.interfaces.gui.CalculatorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment =
            CalculatorFragment()

        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }


}
