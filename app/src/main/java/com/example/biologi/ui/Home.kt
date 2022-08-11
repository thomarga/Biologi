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


        //send data protista yang berisi string protista.pdf ke activity lain sekaligus
        // pindah activity
        materiButton.setOnClickListener {
            val intent = Intent(this, PdfView::class.java)
            intent.putExtra("protista", "protista")
            startActivity(intent)
        }

        //direct ke browser dengan url yang sudah di inisiasi
        evaluasiPembelajaranButton.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://quizizz.com/join?gc=46221277")
            )
            startActivity(browserIntent)
        }

        kompetensiDasarButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title = "Kompetensi",
                content = "3.6 Mengelompokkan protista berdasarkan ciri-ciri umum kelas dan mengaitkan peranannya dalam kehidupan \n" +
                        "4.6 Menyajikan laporan hasil investigasi tentang berbagai peranan protista dalam kehidupan\n",
                buttonText = "Kembali"
            )
        }

        profilPengembangButton.setOnClickListener {
            startActivity(Intent(this, About::class.java))
        }

        petunjukPenggunaanButton.setOnClickListener {
          startActivity(Intent(this,PetunjukPenggunaan::class.java))
        }

        daftarPustakaButton.setOnClickListener {
           startActivity(Intent(this,Dapus::class.java))
        }

        petaKonsepButton.setOnClickListener {
            startActivity(Intent(this, PetaKonsep::class.java))
        }

        glosariumButton.setOnClickListener {
            val intent = Intent(this, PdfView::class.java)
            intent.putExtra("protista", "glosarium")
            startActivity(intent)
        }
    }
}