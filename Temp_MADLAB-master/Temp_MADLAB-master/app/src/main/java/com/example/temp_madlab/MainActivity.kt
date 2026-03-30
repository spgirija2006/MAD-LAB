package com.example.temperatureconverter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemperature = findViewById<EditText>(R.id.etTemperature)
        val rbCtoF = findViewById<RadioButton>(R.id.rbCtoF)
        val rbFtoC = findViewById<RadioButton>(R.id.rbFtoC)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val tempInput = etTemperature.text.toString()

            if (tempInput.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val temp = tempInput.toDoubleOrNull()
            if (temp == null) {
                Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = if (rbCtoF.isChecked) {
                // Celsius to Fahrenheit
                (temp * 9/5) + 32
            } else {
                // Fahrenheit to Celsius
                (temp - 32) * 5/9
            }

            val unit = if (rbCtoF.isChecked) "°F" else "°C"
            tvResult.text = "Result: %.2f %s".format(result, unit)
        }
    }
}