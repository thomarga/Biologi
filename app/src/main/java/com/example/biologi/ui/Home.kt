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
            val intent = Intent(this, PdfView::class.java)
            intent.putExtra("protista", "protista_materi")
            startActivity(intent)
        }

        //direct ke browser dengan url yang sudah di inisiasi
        evaluasiPembelajaranButton.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://quizizz.com/admin/quiz/62904d81b8625f001d40de24")
            )
            startActivity(browserIntent)
        }

        kompetensiDasarButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title = "Kompetensi",
                content = "3.6 Mengelompokkan protista berdasarkan ciri-ciri umum kelas dan mengaitkan peranannya dalam kehidupan \n" +
                        "\t4.6 Menyajikan laporan hasil investigasi tentang berbagai peranan protista dalam \tkehidupan\n",
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