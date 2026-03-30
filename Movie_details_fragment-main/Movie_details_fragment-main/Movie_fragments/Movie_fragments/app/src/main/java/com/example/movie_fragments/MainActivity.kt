package com.example.movie_fragments


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById<Button>(R.id.btn)

        val basicFragmentManager : FragmentManager = supportFragmentManager
        val basicFragmentTransaction : FragmentTransaction = basicFragmentManager.beginTransaction()
        val basicFragment = firstFragment()
        basicFragmentTransaction.add(R.id.fragment,basicFragment)
        basicFragmentTransaction.commit()

        btn.setOnClickListener {
            val additionalFragmentManager : FragmentManager = supportFragmentManager
            val additionalFragmentTransaction : FragmentTransaction = additionalFragmentManager.beginTransaction()
            val additionalFragment = additional_Fragment()
            additionalFragmentTransaction.replace(R.id.fragment,additionalFragment)
            additionalFragmentTransaction.commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}