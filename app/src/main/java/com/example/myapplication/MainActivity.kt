package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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

    private var calculationBar = " "
    private var separateCalRes = ""

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
            calculationBar = " "
            result.text = "0"
        }

        buttonZero.setOnClickListener {
            calculationBar += getString(R.string.Zero)
            result.text = calculationBar
        }

        buttonOne.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "1"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.One)
                result.text = calculationBar
            }
        }

        buttonTwo.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "2"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Two)
                result.text = calculationBar
            }
        }

        buttonThree.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "3"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Three)
                result.text = calculationBar
            }
        }

        buttonFour.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "4"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Four)
                result.text = calculationBar
            }
        }

        buttonFive.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "5"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Five)
                result.text = calculationBar
            }
        }

        buttonSix.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "6"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Six)
                result.text = calculationBar
            }
        }

        buttonSeven.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "7"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Seven)
                result.text = calculationBar
            }
        }

        buttonEight.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "8"
                result.text = calculationBar
            } else {
                calculationBar += getString(R.string.Eight)
                result.text = calculationBar
            }
        }

        buttonNine.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "9"
                result.text = calculationBar

            }

            else {
                calculationBar += getString(R.string.Nine)
                result.text = calculationBar
            }
        }

        buttonSum.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "0"
                result.text = "0"
            }
            if (calculationBar.first().toString() == "-") {
                calculationBar = "0$separateCalRes"
                calculationBar += getString(R.string.Sum)
                result.text = calculationBar.removePrefix("0")
            } else {
                calculationBar += getString(R.string.Sum)
                result.text = calculationBar
            }
        }
        buttonMinus.setOnClickListener {
            if (calculationBar.first().toString() == " ") {
                calculationBar = "0"
                result.text = "0"
            }
            if (calculationBar.last().toString() != getString(R.string.Minus)) {
                if (calculationBar.first().toString() == "-") {
                    calculationBar = "0$separateCalRes"
                    calculationBar += getString(R.string.Minus)
                    result.text = calculationBar.removePrefix("0")
                } else {
                    calculationBar += getString(R.string.Minus)
                    result.text = calculationBar
                }
            }
        }

        buttonCalculate.setOnClickListener {
            if (calculationBar.last().toString() != getString(R.string.Sum)
                    && calculationBar.last().toString() != getString(R.string.Minus)
                    && calculationBar.first().toString() != getString(R.string.Sum)
                    && calculationBar.first().toString() != getString(R.string.Minus)) {
                if (calculationBar == getString(R.string.esterEggVal)) {
                    result.text = getString(R.string.esterEgg)
                } else {

                    val calculationResult = calculate()

                    when {
                        calculationResult == "0" -> {
                            calculationBar = " "
                            result.text = "0"

                        }
                        calculationResult.first() == '-' -> {
                            calculationBar = calculationResult
                            result.text = calculationResult

                        }
                        else -> {
                            calculationBar = calculationResult
                            result.text = calculationResult
                        }
                    }
                    separateCalRes = calculationResult
                }

            }
        }
    }

    private fun calculate(): String {
        val reg = Regex("(?<=[-+])|(?=[+-])")
        var result = 0
        var operatorElement = ""

        val expressionList = calculationBar.split(reg).map { numberString ->
            numberString.replace(" ", "")
        }

        expressionList.forEachIndexed { index, element ->
            if (index == 0) {
                result = element.toInt()

            } else if (element == "+") {
                operatorElement = "+"

            } else if (element == "-") {
                operatorElement = "-"

            } else {
                if (operatorElement == "+") {
                    result += element.toInt()

                } else {
                    result -= element.toInt()
                }
            }
            Toast.makeText(applicationContext, R.string.ToastMassage,
                    Toast.LENGTH_SHORT).show()
        }
        return result.toString()
    }


}
