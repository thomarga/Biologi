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

        textView7.text= "Puji syukur penulis panjatkan kepada Tuhan Yang Maha Esa atas berkat dan " +
                "rahmatnya penulis mampu menyelesaikan skripsi penyusunan bahan ajar “E-Modul berbasis " +
                "aplikasi android materi Protista kelas X” dengan tujuan untuk memfasilitasi peserta " +
                "didik agar dapat melaksanakan aktivitas pembelajaran secara mandiri sesuai dengan " +
                "kemampuan tanpa tergantung dari guru dan dapat diakses secara online maupun offline.\n" +
                "        \nPenulis ucapkan terimakasih kepada semua pihak yang telah mendukung, " +
                "memotivasi dan membantu penyelesaian pembuatan aplikasi ini.\n" +
                "        \nPenulis menyadari aplikasi e modul ini masih jauh dari kata sempurna " +
                "oleh sebab itu kritik dan saran yang membangun sangat diharapkan oleh penulis"

        button3.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }
    }
}