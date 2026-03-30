package com.example.collegevalidation

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.digii.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnValidate = findViewById<Button>(R.id.btnValidate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnValidate.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            // Check empty fields
            if (email.isEmpty() || password.isEmpty()) {
                tvResult.text = "Result: Both fields are required."
                return@setOnClickListener
            }

            // Validate college email (example: ends with "@college.edu")
            val emailPattern = "^[A-Za-z0-9._%+-]+@college\\.edu$".toRegex()
            if (!email.matches(emailPattern)) {
                tvResult.text = "Result: Enter a valid college email."
                return@setOnClickListener
            }

            // Validate password
            val passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{12,}$".toRegex()
            if (!password.matches(passwordPattern)) {
                tvResult.text = "Result: Password must have at least 12 characters, including 1 uppercase, 1 number, and 1 special character."
                return@setOnClickListener
            }

            tvResult.text = "Result: Validation Successful ✅"
        }
    }
}