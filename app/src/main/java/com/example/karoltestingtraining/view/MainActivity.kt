package com.example.karoltestingtraining.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.karoltestingtraining.R
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.karoltestingtraining.viewmodel.CalculatorViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this)[CalculatorViewModel::class.java]

        bCalculate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                model.sum()
            }
        })
    }


}
