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
    private lateinit var buttonClearAll: Button

    private lateinit var result: TextView
    private var startResult = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonZero = findViewById(R.id.zero)
        buttonOne = findViewById(R.id.one)
        buttonTwo = findViewById(R.id.two)
        buttonThree = findViewById(R.id.three)
        buttonFour = findViewById(R.id.four)
        buttonFive = findViewById(R.id.five)
        buttonSix = findViewById(R.id.six)
        buttonSeven = findViewById(R.id.seven)
        buttonEight = findViewById(R.id.eight)
        buttonNine = findViewById(R.id.nine)

        buttonSum = findViewById(R.id.sum)
        buttonCalculate = findViewById(R.id.calculate)
        buttonClearAll = findViewById(R.id.clearAll)

        result = findViewById(R.id.resultID)

        buttonClearAll.setOnClickListener {
            startResult = " "
            result.text = "0"
        }

        buttonZero.setOnClickListener {
            startResult += getString(R.string.Zero)
            result.text = startResult
        }

        buttonOne.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "1"
                result.text = startResult
            } else {
                startResult += getString(R.string.One)
                result.text = startResult
            }

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
            if (startResult.first().toString() == " ") {
                startResult = "0"
                result.text = "0"
            }
            if (startResult.last().toString() != getString(R.string.Sum)) {
                startResult += getString(R.string.Sum)
                result.text = startResult
            }
        }

        buttonCalculate.setOnClickListener {
            if (startResult.last().toString() == "+") {
                startResult.dropLast(1)
                result.text = startResult
            }
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