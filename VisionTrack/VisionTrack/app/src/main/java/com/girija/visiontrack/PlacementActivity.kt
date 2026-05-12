package com.girija.visiontrack

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PlacementActivity : AppCompatActivity() {

    private val companyList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placement)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val inputLayout = findViewById<LinearLayout>(R.id.inputLayout)

        val company = findViewById<EditText>(R.id.etCompany)
        val cgpa = findViewById<EditText>(R.id.etCGPA)
        val lastDate = findViewById<EditText>(R.id.etLastDate)
        val rounds = findViewById<EditText>(R.id.etRounds)
        val dateTime = findViewById<EditText>(R.id.etDateTime)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val listView = findViewById<ListView>(R.id.listView)
        val tvCount = findViewById<TextView>(R.id.tvCount)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, companyList)
        listView.adapter = adapter

        // 🔹 Show form
        btnAdd.setOnClickListener {
            inputLayout.visibility = LinearLayout.VISIBLE
        }

        // 🔹 LAST DATE PICKER
        lastDate.setOnClickListener {
            val cal = Calendar.getInstance()

            val datePicker = DatePickerDialog(this,
                { _, y, m, d ->
                    lastDate.setText("$d/${m + 1}/$y")
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        // 🔹 INTERVIEW DATE + TIME PICKER
        dateTime.setOnClickListener {
            val cal = Calendar.getInstance()

            val datePicker = DatePickerDialog(this,
                { _, y, m, d ->

                    val timePicker = TimePickerDialog(this,
                        { _, hour, min ->
                            dateTime.setText("$d/${m + 1}/$y  $hour:$min")
                        },
                        cal.get(Calendar.HOUR_OF_DAY),
                        cal.get(Calendar.MINUTE),
                        true
                    )
                    timePicker.show()

                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        // 🔹 SAVE
        btnSave.setOnClickListener {

            val data = """
Company: ${company.text}
CGPA: ${cgpa.text}
Last Date: ${lastDate.text}
Rounds: ${rounds.text}
Interview: ${dateTime.text}
            """.trimIndent()

            companyList.add(data)
            adapter.notifyDataSetChanged()

            count++
            tvCount.text = "Total Companies: $count"

            Toast.makeText(this, "Company Added", Toast.LENGTH_SHORT).show()

            // Clear fields
            company.text.clear()
            cgpa.text.clear()
            lastDate.text.clear()
            rounds.text.clear()
            dateTime.text.clear()

            inputLayout.visibility = LinearLayout.GONE
        }
    }
}