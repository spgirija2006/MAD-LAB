package com.example.randomnumbergenerator


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minInput = findViewById<EditText>(R.id.etMin)
        val maxInput = findViewById<EditText>(R.id.etMax)
        val generateBtn = findViewById<Button>(R.id.btnGenerate)
        val resultText = findViewById<TextView>(R.id.tvResult)

        generateBtn.setOnClickListener {

            val minStr = minInput.text.toString()
            val maxStr = maxInput.text.toString()

            if (minStr.isEmpty() || maxStr.isEmpty()) {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val min = minStr.toInt()
            val max = maxStr.toInt()

            if (min > max) {
                Toast.makeText(this, "Minimum must be less than maximum", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomNumber = Random.nextInt(min, max + 1)
            resultText.text = "Random Number: $randomNumber"
        }
    }
}