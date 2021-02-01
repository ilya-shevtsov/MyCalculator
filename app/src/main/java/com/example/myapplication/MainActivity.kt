package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.RuntimeException

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
    private lateinit var buttonClearLast: Button

    private lateinit var result: TextView
    private lateinit var headText: TextView

    private val onPlaneReceiver: BroadcastReceiver = SimpleBroadcast()
    private val intentFilter: IntentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

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
        buttonClearLast = findViewById(R.id.deleteLastElement)

        result = findViewById(R.id.resultID)
        headText = findViewById(R.id.headText)

        buttonClearAll.setOnClickListener {
            calculationBar = "0"
            result.text = "0"
        }

        buttonClearLast.setOnClickListener {
            handleDeleteLastButton()
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
                && calculationBar.last().toString() != getString(R.string.Minus)
            ) {
                when (calculationBar) {
                    getString(R.string.lostEsterEggVal) -> result.text =
                        getString(R.string.lostEsterEgg)
                    getString(R.string.quickMathsEasterEggVal) -> result.text =
                        getString(R.string.quickMathsEasterEgg)
                    getString(R.string.csEasterEggVal) -> result.text =
                        getString(R.string.csEasterEgg)
                    else -> {
                        val calculationResult = calculate()
                        calculationBar = calculationResult
                        result.text = calculationResult
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(onPlaneReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        val intentActionService = Intent(
            this, ActionService::class.java
        )
        startService(intentActionService)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_title_color_blue ->
                headText.setBackgroundResource(R.color.blue)
            R.id.change_title_color_red ->
                headText.setBackgroundResource(R.color.red)
            R.id.change_title_color_green ->
                headText.setBackgroundResource(R.color.green)
            R.id.change_title_color_default ->
                headText.setBackgroundResource(R.color.black)
        }
        return true
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

    private fun handleDeleteLastButton() {
        if (
            calculationBar.length < 2
            || (calculationBar.length <= 2 && calculationBar.first().toString() == "-")
        ) {
            calculationBar = "0"
            result.text = calculationBar
        }
        if (calculationBar.length > 1) {
            calculationBar = calculationBar.dropLast(1)
            result.text = calculationBar
        }
    }

    private fun calculate(): String {
        val reg = Regex("(?<=[-+])|(?=[+-])")
        var result = 0
        var operatorElement = "+"

        var expressionList = calculationBar.split(reg)
            .map { numberString ->
                return@map numberString.replace(" ", "")
            }
            .filter { element ->
                element != ""
            }

        if (expressionList.first() == "-") {
            expressionList = listOf("0") + expressionList
        }

        expressionList.forEach { element ->
            when (element) {
                "+" -> operatorElement = "+"
                "-" -> operatorElement = "-"
                else -> {
                    when (operatorElement) {
                        "+" -> result += element.toInt()
                        "-" -> result -= element.toInt()
                        else -> throw RuntimeException("Invalid OperatorElement")
                    }
                }
            }
            Toast.makeText(
                applicationContext, R.string.ToastMassage,
                Toast.LENGTH_SHORT
            ).show()
        }
        return result.toString()
    }
}