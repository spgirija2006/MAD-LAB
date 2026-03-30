package com.example.panandpincodevalidation


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val panInput = findViewById<EditText>(R.id.etPan)
        val pinInput = findViewById<EditText>(R.id.etPincode)
        val validateBtn = findViewById<Button>(R.id.btnValidate)

        validateBtn.setOnClickListener {

            val pan = panInput.text.toString().trim()
            val pincode = pinInput.text.toString().trim()

            // 1. Check empty fields
            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. PAN validation (10 alphanumeric characters)
            val panPattern = Regex("^[A-Za-z0-9]{10}$")
            if (!pan.matches(panPattern)) {
                Toast.makeText(
                    this,
                    "PAN must be 10 alphanumeric characters",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // 3. Pincode validation (6 digits only)
            val pinPattern = Regex("^\\d{6}$")
            if (!pincode.matches(pinPattern)) {
                Toast.makeText(
                    this,
                    "Pincode must be exactly 6 digits",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // If all valid
            Toast.makeText(this, "Validation Successful ✅", Toast.LENGTH_LONG).show()
        }
    }
}