package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonSum: Button
    private lateinit var buttonCalculate: Button
    private lateinit var result: TextView
    private var startResult = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.One)
        buttonTwo = findViewById(R.id.Two)
        buttonSum = findViewById(R.id.Sum)
        buttonCalculate = findViewById(R.id.Calculate)
        result = findViewById(R.id.ResultID)
        result.text = startResult

        result.setOnClickListener {
            startResult = " "
            result.text = " "
        }

        buttonOne.setOnClickListener {
            startResult += getString(R.string.One)
            result.text = startResult
        }

        buttonTwo.setOnClickListener {
            startResult += getString(R.string.Two)
            result.text = startResult
        }

        buttonSum.setOnClickListener {
            startResult += getString(R.string.Sum)
            result.text = startResult
        }

        buttonCalculate.setOnClickListener {
            result.text = calculate()
        }


    }

    private fun calculate(): String {
        val split = startResult.split("+")
        val numbers = split.map { numberString ->
            numberString.replace(" ","").toInt()
        }
        return numbers.sum().toString()
    }
}