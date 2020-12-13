package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.One)
        buttonTwo = findViewById(R.id.Two)
        result = findViewById(R.id.ResultID)

        buttonOne.setOnClickListener{
            result.text = getString(R.string.One)
        }

        buttonTwo.setOnClickListener{
            result.text = getString(R.string.Two)
        }

    }
}