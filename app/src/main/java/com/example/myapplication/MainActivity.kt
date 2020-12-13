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
    private lateinit var buttonMinus: Button
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
        buttonMinus = findViewById(R.id.minus)
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
            if (startResult.first().toString() == " ") {
                startResult = "2"
                result.text = startResult
            } else {
                startResult += getString(R.string.Two)
                result.text = startResult
            }
        }

        buttonThree.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "3"
                result.text = startResult
            } else {
                startResult += getString(R.string.Three)
                result.text = startResult
            }
        }

        buttonFour.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "4"
                result.text = startResult
            } else {
                startResult += getString(R.string.Four)
                result.text = startResult
            }
        }

        buttonFive.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "5"
                result.text = startResult
            } else {
                startResult += getString(R.string.Five)
                result.text = startResult
            }
        }

        buttonSix.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "6"
                result.text = startResult
            } else {
                startResult += getString(R.string.Six)
                result.text = startResult
            }
        }

        buttonSeven.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "7"
                result.text = startResult
            } else {
                startResult += getString(R.string.Seven)
                result.text = startResult
            }
        }

        buttonEight.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "8"
                result.text = startResult
            } else {
                startResult += getString(R.string.Eight)
                result.text = startResult
            }
        }

        buttonNine.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "9"
                result.text = startResult
            } else {
                startResult += getString(R.string.Nine)
                result.text = startResult
            }
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
        buttonMinus.setOnClickListener {
            if (startResult.first().toString() == " ") {
                startResult = "0"
                result.text = "0"
            }
            if (startResult.last().toString() != getString(R.string.Minus)) {
                startResult += getString(R.string.Minus)
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