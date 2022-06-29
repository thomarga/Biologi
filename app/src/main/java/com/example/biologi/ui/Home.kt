package com.example.biologi.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import com.example.biologi.showSingleButtonWarningDialog
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //send data protista yang berisi string protista_materi.pdf ke activity lain sekaligus
        // pindah activity
        materiButton.setOnClickListener {
            val intent= Intent(this, PdfView::class.java)
            intent.putExtra("protista","protista_materi.pdf")
            startActivity(intent)
        }

        //direct ke browser dengan url yang sudah di inisiasi
        latihanButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://quizizz.com/admin/quiz/62904d81b8625f001d40de24"))
            startActivity(browserIntent)
        }

        kompetensiMateriButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title = "Kompetensi",
                content = "KD 3.6 Mengelompokkan protista berdasarkan ciri-ciri umum kelas dan " +
                        "mengaitkan peranannya dalam kehidupan ",
                buttonText = "Oke"
            )
        }

        aboutButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title = "Tentang",
                content = "Aplikasi ini merupakan media pembelajaran berbasis android yang " +
                        "dapat digunakan secara mandiri oleh peserta didik kelas x SMA pada materi protista \n" +
                        " \n" +
                        "181434076\n" +
                        "Yoan Sherlia Zendi \n",
                buttonText = "Oke"
            )
        }
    }
}