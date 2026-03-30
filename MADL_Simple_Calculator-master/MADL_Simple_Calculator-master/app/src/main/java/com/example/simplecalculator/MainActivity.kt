package com.example.simplecalculator   // change if needed

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var firstNumber = 0.0
    private var operator = ""
    private var isNewNumber = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.tvDisplay)
        val grid = findViewById<GridLayout>(R.id.gridButtons)

        // Loop through all buttons inside GridLayout
        for (i in 0 until grid.childCount) {
            val button = grid.getChildAt(i) as Button
            button.setOnClickListener {
                onButtonClick(button.text.toString())
            }
        }
    }

    private fun onButtonClick(value: String) {

        when (value) {

            "C" -> {
                display.text = "0"
                firstNumber = 0.0
                operator = ""
                isNewNumber = true
            }

            "+", "-", "*", "/" -> {
                firstNumber = display.text.toString().toDouble()
                operator = value
                isNewNumber = true
            }

            "=" -> {
                val secondNumber = display.text.toString().toDouble()
                val result = when (operator) {
                    "+" -> firstNumber + secondNumber
                    "-" -> firstNumber - secondNumber
                    "*" -> firstNumber * secondNumber
                    "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else 0.0
                    else -> 0.0
                }
                display.text = result.toString()
                isNewNumber = true
            }

            else -> { // numbers
                if (isNewNumber) {
                    display.text = value
                    isNewNumber = false
                } else {
                    display.append(value)
                }
            }
        }
    }
}