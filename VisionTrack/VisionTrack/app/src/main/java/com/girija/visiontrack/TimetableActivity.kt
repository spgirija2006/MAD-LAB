package com.girija.visiontrack

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TimetableActivity : AppCompatActivity() {

    private var examUri: Uri? = null
    private var classUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        val btnUploadExam = findViewById<Button>(R.id.btnUploadExam)
        val btnUploadClass = findViewById<Button>(R.id.btnUploadClass)
        val btnViewExam = findViewById<Button>(R.id.btnViewExam)
        val btnViewClass = findViewById<Button>(R.id.btnViewClass)

        // Upload Exam
        btnUploadExam.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, 1)
        }

        // Upload Class
        btnUploadClass.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, 2)
        }

        // View Exam File
        btnViewExam.setOnClickListener {
            examUri?.let {
                openFile(it)
            } ?: Toast.makeText(this, "No Exam File", Toast.LENGTH_SHORT).show()
        }

        // View Class File
        btnViewClass.setOnClickListener {
            classUri?.let {
                openFile(it)
            } ?: Toast.makeText(this, "No Class File", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null) {
            val uri = data.data

            if (requestCode == 1) {
                examUri = uri
                Toast.makeText(this, "Exam Timetable Uploaded", Toast.LENGTH_SHORT).show()
            } else if (requestCode == 2) {
                classUri = uri
                Toast.makeText(this, "Class Timetable Uploaded", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openFile(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, "*/*")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(intent)
    }
}