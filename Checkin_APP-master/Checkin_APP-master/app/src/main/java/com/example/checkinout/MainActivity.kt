package com.example.exp1



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.checkinout.R

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterText = findViewById<TextView>(R.id.counterText)
        val checkInBtn = findViewById<Button>(R.id.btnCheckIn)
        val checkOutBtn = findViewById<Button>(R.id.btnCheckOut)

        counterText.text = count.toString()

        checkInBtn.setOnClickListener {
            count++
            counterText.text = count.toString()
        }

        checkOutBtn.setOnClickListener {
            if (count > 0) {
                count--
                counterText.text = count.toString()
            }
        }
    }
}
