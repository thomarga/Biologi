package com.example.biologi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import kotlinx.android.synthetic.main.activity_kata_pengantar.*

class KataPengantar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kata_pengantar)

        button3.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}