package com.example.biologi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import kotlinx.android.synthetic.main.activity_peta_konsep.*
import kotlinx.android.synthetic.main.toolbar.view.*

class PetaKonsep : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peta_konsep)

        petaKonsepToolbar.textViewToolbar.text = "Peta Konsep"
    }
}