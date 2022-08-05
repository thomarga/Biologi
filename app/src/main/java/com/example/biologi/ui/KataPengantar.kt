package com.example.biologi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import com.example.biologi.spannedHtml
import kotlinx.android.synthetic.main.activity_kata_pengantar.*

class KataPengantar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kata_pengantar)

        textView7.text= getString(R.string.kataPengantar).spannedHtml()

        button3.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}