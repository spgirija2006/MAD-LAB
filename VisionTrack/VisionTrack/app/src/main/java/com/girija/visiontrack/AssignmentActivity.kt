package com.girija.visiontrack

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class AssignmentActivity : AppCompatActivity() {

    private val list = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val inputLayout = findViewById<LinearLayout>(R.id.inputLayout)

        val subject = findViewById<EditText>(R.id.etSubject)
        val title = findViewById<EditText>(R.id.etTitle)
        val date = findViewById<EditText>(R.id.etDate)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val listView = findViewById<ListView>(R.id.listView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        // 🔹 Show form
        btnAdd.setOnClickListener {
            inputLayout.visibility = LinearLayout.VISIBLE
        }

        // 🔹 DATE PICKER
        date.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,
                { _, y, m, d ->
                    date.setText("$d/${m + 1}/$y")
                }, year, month, day)

            datePicker.show()
        }

        // 🔹 SAVE
        btnSave.setOnClickListener {

            val data = """
Subject: ${subject.text}
Title: ${title.text}
Due Date: ${date.text}
            """.trimIndent()

            list.add(data)
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "Assignment Added", Toast.LENGTH_SHORT).show()

            // Clear
            subject.text.clear()
            title.text.clear()
            date.text.clear()

            inputLayout.visibility = LinearLayout.GONE
        }
    }
}