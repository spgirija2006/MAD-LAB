package com.example.randomnumbergenerator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.random_no.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMin = findViewById<EditText>(R.id.etMin)
        val etMax = findViewById<EditText>(R.id.etMax)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnGenerate.setOnClickListener {
            val minText = etMin.text.toString()
            val maxText = etMax.text.toString()

            if (minText.isEmpty() || maxText.isEmpty()) {
                Toast.makeText(this, "Please enter both minimum and maximum values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val min = minText.toIntOrNull()
            val max = maxText.toIntOrNull()

            if (min == null || max == null) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (min > max) {
                Toast.makeText(this, "Minimum should be less than or equal to Maximum", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomNumber = Random.nextInt(min, max + 1) // max is exclusive, so +1
            tvResult.text = "Random Number: $randomNumber"
        }
    }
}