package com.example.biologi.ui

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bluehomestudio.luckywheel.WheelItem
import com.example.biologi.R
import kotlinx.android.synthetic.main.activity_spin.*


class Spin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spin)

        val intentt = intent
        val myList = intentt.getSerializableExtra("materi") as ArrayList<*>?
        //membuat array color
        val color = arrayListOf(
            Color.parseColor("#476088"),
            Color.parseColor("#FFC562"),
            Color.parseColor("#FF6D74"),
            Color.parseColor("#61A8E8"),
            Color.parseColor("#4FDDC3"),
            Color.parseColor("#61A8E8")
        )
        val wheelItems: MutableList<WheelItem> = ArrayList()

        if (myList != null) {
            for (i in myList.indices) {
                wheelItems.add(
                    WheelItem(
                        color[i],
                        BitmapFactory.decodeResource(resources,
                            R.drawable.ice_creama
                        ),
                        myList[i] as String?
                    )
                )
            }
        }

        lwv.addWheelItems(wheelItems)

        var getValue = 0
        button.setOnClickListener {
            val index = myList?.indices
            if (index != null) {
                getValue = index.random() + 1
            }
            lwv.rotateWheelTo(getValue)

        }
        lwv.setLuckyWheelReachTheTarget {
            Toast.makeText(this, "Target Reached ${myList?.get(getValue-1)}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, PdfView::class.java)
            intent.putExtra("protista", "${myList?.get(getValue-1)}")
            startActivity(intent)
        }
    }
}