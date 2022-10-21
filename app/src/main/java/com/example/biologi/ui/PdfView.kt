package com.example.biologi.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.*
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.shockwave.pdfium.PdfDocument
import kotlinx.android.synthetic.main.pdf_view.*
import kotlinx.android.synthetic.main.toolbar.view.*


class PdfView : AppCompatActivity(), OnPageChangeListener, OnLoadCompleteListener,
    OnPageErrorListener {
    private var pageNumber: Int = 0
    private var pdfFileName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdf_view)

        floatingActionButton2.setOnClickListener{
            startActivity(Intent(this,WebViewActivity::class.java))
        }


        val intent = intent
        Log.e("materi", intent.getStringExtra("protista").toString())
//        includePdf.textViewToolbar.visibility = INVISIBLE
        pdfView.fromAsset("${intent.getStringExtra("protista")}.pdf")
            .defaultPage(pageNumber)
            .onPageChange(this)
            .enableAnnotationRendering(true)
            .onLoad(this)
            .scrollHandle(DefaultScrollHandle(this))
            .spacing(10) // in dp
            .onPageError(this)
            .load()


        when (intent.getStringExtra("protista").toString()) {
             "Protista" -> {
//                fungiBtn.visibility = VISIBLE
//                ganggangBtn.visibility = VISIBLE
//                protozoaBtn.visibility = VISIBLE
                linearPdfView.visibility = VISIBLE
                 lanjutViewButton.visibility = GONE
            }
            "pengantar fungi","pengantar hewan","pengantar tumbuhan" -> {
                fungiBtn.visibility = GONE
                ganggangBtn.visibility = GONE
                protozoaBtn.visibility = GONE
                peranBtn.visibility = GONE
            }
            else -> {
                fungiBtn.visibility = GONE
                ganggangBtn.visibility = GONE
                protozoaBtn.visibility = GONE
                peranBtn.visibility = GONE
                lanjutViewButton.visibility = GONE
                val a = linearPdfView.layoutParams as RelativeLayout.LayoutParams
                a.setMargins(0,0,0,0)
            }
        }

        fungiBtn.setOnClickListener {
            fungi()
        }

        ganggangBtn.setOnClickListener {
            ganggang()
        }

        protozoaBtn.setOnClickListener {
            protozoa()
        }

        peranBtn.setOnClickListener {
            kegunaan()
        }

        lanjutViewButton.setOnClickListener {
lanjutkan()
        }
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber = page
        title = String.format("%s %s / %s", pdfFileName, page + 1, pageCount)
        Log.e("tes", pageNumber.toString())
//        when (pageNumber+1==pageCount){
//            true->button2.visibility = VISIBLE
//            else -> {}
//        }
    }

    override fun loadComplete(nbPages: Int) {
        val meta: PdfDocument.Meta = pdfView.documentMeta
    }

    override fun onPageError(page: Int, t: Throwable?) {

    }

    private fun spin() {
        val materi = arrayListOf("fungi", "ganggang", "protozoa")
        val intent = Intent(this, Spin::class.java)
        intent.putExtra("materi", materi)
        startActivity(intent)
    }

    private fun fungi() {
        val materi = "pengantar fungi"
        val intent = Intent(this, PdfView::class.java)
        intent.putExtra("protista", materi)
        startActivity(intent)
        finish()
    }

    private fun ganggang() {
        val materi = "pengantar tumbuhan"
        val intent = Intent(this, PdfView::class.java)
        intent.putExtra("protista", materi)
        startActivity(intent)
        finish()
    }

    private fun protozoa() {
        val materi = "pengantar hewan"
        val intent = Intent(this, PdfView::class.java)
        intent.putExtra("protista", materi)
        startActivity(intent)
        finish()
    }

    fun kegunaan() {
        val intent = Intent(this, PdfView::class.java)
        intent.putExtra("protista", "peran")
        startActivity(intent)
        finish()
    }

    fun lanjutkan(){
        var materi: ArrayList<String>? = null
        when (intent.getStringExtra("protista").toString()){
            "pengantar hewan" -> materi = arrayListOf("Rhizopodha", "Flagelata", "Cilliata", "Sporozoa")
            "pengantar tumbuhan" -> materi = arrayListOf("Rhodophyta", "Phaeophyta", "Chrysophyta", "Chilorophyta","Bacilliarophyta", "Euglenophyta")
            "pengantar fungi" -> materi = arrayListOf("Myxomycota", "Oomycota", "Acrasiomycot")
        }
        val intent = Intent(this, Spin::class.java)
        intent.putExtra("materi", materi)
        startActivity(intent)
    }
}