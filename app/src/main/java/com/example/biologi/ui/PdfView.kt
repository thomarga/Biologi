package com.example.biologi.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.biologi.R
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.shockwave.pdfium.PdfDocument
import kotlinx.android.synthetic.main.pdf_view.*


class PdfView : AppCompatActivity(),OnPageChangeListener,OnLoadCompleteListener,OnPageErrorListener {
    private var pageNumber:Int=0
    private var pdfFileName:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdf_view)

        val intent = intent
        Log.e("materi",intent.getStringExtra("protista").toString())
        pdfView.fromAsset(intent.getStringExtra("protista").toString())
            .defaultPage(pageNumber)
            .onPageChange(this)
            .enableAnnotationRendering(true)
            .onLoad(this)
            .scrollHandle(DefaultScrollHandle(this))
            .spacing(10) // in dp
            .onPageError(this)
            .load()

        button2.setOnClickListener {
            spin()
        }

        when(intent.getStringExtra("protista").toString()=="protista_materi.pdf"){
            true->{
                fungiBtn.visibility= VISIBLE
                ganggangBtn.visibility= VISIBLE
                protozoaBtn.visibility= VISIBLE
            }
            false->{
                fungiBtn.visibility= INVISIBLE
                ganggangBtn.visibility= INVISIBLE
                protozoaBtn.visibility= INVISIBLE
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
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber=page
        title = String.format("%s %s / %s", pdfFileName, page + 1, pageCount)
        Log.e("tes",pageNumber.toString())
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

    private fun spin (){
        val materi = arrayListOf("fungi","ganggang","protozoa")
        val intent= Intent(this, Spin::class.java)
        intent.putExtra("materi",materi)
        startActivity(intent)
    }

    private fun fungi(){
        val materi = arrayListOf("myxomycota","oomycota","acrasiomycota")
        val intent= Intent(this, Spin::class.java)
        intent.putExtra("materi",materi)
        startActivity(intent)
    }

    private fun ganggang(){
        val materi = arrayListOf("rhodophyta","phaeophyta","chrysophyta","chlorophyta",
            "bacillariophyta","euglenophyta")
        val intent= Intent(this, Spin::class.java)
        intent.putExtra("materi",materi)
        startActivity(intent)
    }

    private fun protozoa(){
        val materi = arrayListOf("rizopoda","flagellata","ciliata","sporozoa")
        val intent= Intent(this, Spin::class.java)
        intent.putExtra("materi",materi)
        startActivity(intent)
    }
}