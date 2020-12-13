package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var result: TextView
    private var startResult = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.One)
        buttonTwo = findViewById(R.id.Two)
        result = findViewById(R.id.ResultID)
        result.text = startResult

        result.setOnClickListener{
            startResult = "0"
            result.text = "0"
        }

        buttonOne.setOnClickListener{
            startResult += getString(R.string.One)
            result.text = startResult
        }

        buttonTwo.setOnClickListener{
            startResult += getString(R.string.Two)
            result.text = startResult
        }

    }
}