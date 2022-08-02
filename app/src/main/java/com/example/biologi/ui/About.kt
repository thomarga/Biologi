package com.example.biologi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.toolbar.view.*

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        includeAbout.textViewToolbar.text = "Profil pengembang"
    }
}