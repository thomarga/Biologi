package com.example.biologi.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import com.example.biologi.showSingleButtonWarningDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.view.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //send data protista yang berisi string protista_materi.pdf ke activity lain sekaligus
        // pindah activity
        materiButton.setOnClickListener {
            val intent= Intent(this, PdfView::class.java)
            intent.putExtra("protista","protista_materi")
            startActivity(intent)
        }

        //direct ke browser dengan url yang sudah di inisiasi
        evaluasiPembelajaranButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://quizizz.com/admin/quiz/62904d81b8625f001d40de24"))
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
            startActivity(Intent(this,About::class.java))
        }

        petunjukPenggunaanButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title= " Petunjuk Penggunaan",
                content = "Guna mempermudan teman-teman dalam mempelajari E-Modul Protista ini dan penggunaanya secara maksimal, alangkah baiknya teman teman memahami petunjuk penggunaan sebagai E-Modul ini terlebih dahulu \n" +
                        "•\tPengguna e-modul dapat di akses secara mandiri dan dapat dimulai dari menu apa saja\n" +
                        "•\tBacalah dengan teliti dan seksama pada materi yang akan dipelajari \n" +
                        "•\tScroll ke bawah untuk melihat materi\n" +
                        "•\tZoom In Zoom Out untuk meperbesar materi\n" +
                        "•\tKlik materi (tulisan akan berputar) maka akan terbuka materi yang dipelajari\n" +
                        "•\tPada modul ini telah disediakan evaluasi pembelajaran. Kerjakan secara mandiri dan dikerjakan di platfom yang sudah disediakan. \n" +
                        "•\tJika menemukan kesulitan beritahukanlah pada guru kalian\n",
                buttonText = "Kembali"
            )
        }

        daftarPustakaButton.setOnClickListener {
            showSingleButtonWarningDialog(
                title= " Daftar Pustaka",
                content = "•\tSiti, N., Devi, R., Rofida U. 2020. Biologi untuk SMA/MA Kelas X Peminatan Matematika dan Ilmu-Ilmu Alam. Klaten: Intan Pariwara.\n" +
                        "•\tIrnaningtyas. 2013. Biologi untuk SMA/MA Kelas X Peminatan Matematika dan Ilmu-Ilmu Alam.Jakarta: Erlangga.\n" +
                        "•\tRumiyati, Purnamawati, H., Teo Sukoco. 2019. Biologi untuk SMA/MA Kelas X Peminatan Matematika dan Ilmu-Ilmu Alam. Klaten: Intan Pariwara. \n",
                buttonText = "Kembali"
            )
        }

        petaKonsepButton.setOnClickListener {
            startActivity(Intent(this,PetaKonsep::class.java))
        }
    }
}