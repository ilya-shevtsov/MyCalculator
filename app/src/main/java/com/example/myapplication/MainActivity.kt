package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        private const val START_CHAR = "0"
        private val operators = listOf("+", "-")
    }

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

    private var calculationBar = "0"


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
            calculationBar = "0"
            result.text = "0"
        }

        buttonZero.setOnClickListener {
            calculationBar += getString(R.string.Zero)
            result.text = calculationBar
        }

        buttonOne.setOnClickListener {
            handleButtonPressing("1")
        }

        buttonTwo.setOnClickListener {
            handleButtonPressing("2")
        }

        buttonThree.setOnClickListener {
            handleButtonPressing("3")
        }

        buttonFour.setOnClickListener {
            handleButtonPressing("4")
        }

        buttonFive.setOnClickListener {
            handleButtonPressing("5")
        }

        buttonSix.setOnClickListener {
            handleButtonPressing("6")
        }

        buttonSeven.setOnClickListener {
            handleButtonPressing("7")
        }

        buttonEight.setOnClickListener {
            handleButtonPressing("8")
        }

        buttonNine.setOnClickListener {
            handleButtonPressing("9")
        }

        buttonSum.setOnClickListener {
            handleOperatorButton("+")
        }

        buttonMinus.setOnClickListener {
            handleOperatorButton("-")
        }

        buttonCalculate.setOnClickListener {
            if (calculationBar.last().toString() != getString(R.string.Sum)
                    && calculationBar.last().toString() != getString(R.string.Minus)) {
                if (calculationBar == getString(R.string.esterEggVal)) {
                    result.text = getString(R.string.esterEgg)

                } else {
                    val calculationResult = calculate()
                    calculationBar = calculationResult
                    result.text = calculationResult
                }
            }
        }
    }

    private fun handleButtonPressing(number: String) {
        if (calculationBar == START_CHAR) {
            calculationBar = number
            result.text = calculationBar
        } else {
            calculationBar += number
            result.text = calculationBar
        }
    }

    private fun handleOperatorButton(operator: String) {
        if (calculationBar.last().toString() !in operators) {
            calculationBar += operator
            result.text = calculationBar
        }
    }

    private fun calculate(): String {
        val reg = Regex("(?<=[-+])|(?=[+-])")
        var result = 0
        var operatorElement = ""

        var expressionList = calculationBar.split(reg)
                .map { numberString ->
                    numberString.replace(" ", "")
                }
                .filter { element ->
                    element != ""
                }

        if (expressionList.first() == "-") {
            expressionList = listOf("0") + expressionList
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