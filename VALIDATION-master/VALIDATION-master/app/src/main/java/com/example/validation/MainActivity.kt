package com.example.usernameidvalidation

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.validation.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etID = findViewById<EditText>(R.id.etID)
        val btnValidate = findViewById<Button>(R.id.btnValidate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnValidate.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val id = etID.text.toString().trim()

            // Check empty fields
            if (username.isEmpty() || id.isEmpty()) {
                tvResult.text = "Result: Both fields are required."
                return@setOnClickListener
            }

            // Validate username (alphabets only)
            val usernamePattern = "^[A-Za-z]+$".toRegex()
            if (!username.matches(usernamePattern)) {
                tvResult.text = "Result: Username must contain alphabets only."
                return@setOnClickListener
            }

            // Validate ID (numeric, 4 digits)
            val idPattern = "^\\d{4}$".toRegex()
            if (!id.matches(idPattern)) {
                tvResult.text = "Result: ID must be a 4-digit number."
                return@setOnClickListener
            }

            tvResult.text = "Result: Validation Successful ✅"
        }
    }
}