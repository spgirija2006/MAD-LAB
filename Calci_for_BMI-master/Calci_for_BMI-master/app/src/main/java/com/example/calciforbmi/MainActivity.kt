package com.example.bmiapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.calciforbmi.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight = findViewById<EditText>(R.id.weight)
        val height = findViewById<EditText>(R.id.height)
        val button = findViewById<Button>(R.id.button)
        val result = findViewById<TextView>(R.id.result)

        button.setOnClickListener {

            val w = weight.text.toString().toDouble()
            val h = height.text.toString().toDouble()

            val bmi = w / (h * h)

            result.text = "BMI = $bmi"
        }
    }
}