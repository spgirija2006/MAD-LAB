package com.girija.visiontrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val academic = findViewById<Button>(R.id.btnAcademic)

        val placement = findViewById<Button>(R.id.btnPlacement)
        val profile = findViewById<Button>(R.id.btnProfile)

        academic.setOnClickListener {
            startActivity(Intent(this, AcademicActivity::class.java))
        }



        placement.setOnClickListener {
            val intent = Intent(this, PlacementActivity::class.java)
            startActivity(intent)
        }


    }
}

