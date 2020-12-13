package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonZero: Button
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonEight: Button
    private lateinit var buttonNine: Button

    private lateinit var buttonSum: Button
    private lateinit var buttonCalculate: Button
    private lateinit var result: TextView
    private lateinit var ClearAll: Button
    private var startResult = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonZero = findViewById(R.id.Zero)
        buttonOne = findViewById(R.id.One)
        buttonTwo = findViewById(R.id.Two)
        buttonThree = findViewById(R.id.Three)
        buttonFour = findViewById(R.id.Four)
        buttonFive = findViewById(R.id.Five)
        buttonSix = findViewById(R.id.Six)
        buttonSeven = findViewById(R.id.Seven)
        buttonEight = findViewById(R.id.Eight)
        buttonNine = findViewById(R.id.Nine)

        buttonSum = findViewById(R.id.Sum)
        buttonCalculate = findViewById(R.id.Calculate)

        result = findViewById(R.id.ResultID)
        result.text = startResult

        ClearAll.setOnClickListener {
            startResult = " "
            result.text = " "
        }

        buttonZero.setOnClickListener {
            startResult += getString(R.string.Zero)
            result.text = startResult
        }

        buttonOne.setOnClickListener {
            startResult += getString(R.string.One)
            result.text = startResult
        }

        buttonTwo.setOnClickListener {
            startResult += getString(R.string.Two)
            result.text = startResult
        }

        buttonThree.setOnClickListener {
            startResult += getString(R.string.Three)
            result.text = startResult
        }

        buttonFour.setOnClickListener {
            startResult += getString(R.string.Four)
            result.text = startResult
        }

        buttonFive.setOnClickListener {
            startResult += getString(R.string.Five)
            result.text = startResult
        }

        buttonSix.setOnClickListener {
            startResult += getString(R.string.Six)
            result.text = startResult
        }

        buttonSeven.setOnClickListener {
            startResult += getString(R.string.Seven)
            result.text = startResult
        }

        buttonEight.setOnClickListener {
            startResult += getString(R.string.Eight)
            result.text = startResult
        }

        buttonNine.setOnClickListener {
            startResult += getString(R.string.Nine)
            result.text = startResult
        }


        buttonSum.setOnClickListener {
            if (startResult.last().toString() != getString(R.string.Sum)) {
                startResult += getString(R.string.Sum)
                result.text = startResult
            }
        }

        buttonCalculate.setOnClickListener {
            if (startResult.last().toString() != getString(R.string.Sum)) {
                val calculationResult = calculate()
                result.text = calculationResult
                startResult = calculationResult

            }
        }


    }

    private fun calculate(): String {
        val split = startResult.split("+")
        val numbers = split.map { numberString ->
            numberString.replace(" ", "").toInt()
        }
        return numbers.sum().toString()
    }
}