package com.girija.visiontrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AcademicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academic)

        // 🔹 Buttons
        val assignment = findViewById<Button>(R.id.btnAssignment)
        val timetable = findViewById<Button>(R.id.btnTimetable)
        val notes = findViewById<Button>(R.id.btnNotes)

        // 🔹 Click Listeners
        assignment.setOnClickListener {
            val intent = Intent(this, AssignmentActivity::class.java)
            startActivity(intent)
        }

        timetable.setOnClickListener {
            val intent = Intent(this, TimetableActivity::class.java)
            startActivity(intent)
        }

        notes.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }
    }
}