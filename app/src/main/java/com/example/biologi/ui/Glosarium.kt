package com.example.biologi.ui

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.biologi.R
import com.example.biologi.adapter.RecyclerviewGlosariumAdapter
import com.example.biologi.data.GlosariumData
import com.example.biologi.data.IsiData
import kotlinx.android.synthetic.main.activity_glosarium.*
import org.json.JSONObject
import java.io.InputStream

class Glosarium : AppCompatActivity() {

    private lateinit var data: ArrayList<GlosariumData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glosarium)

        data = parseJSON()
        val glosariumAdapter = RecyclerviewGlosariumAdapter(data)
        recyclerViewAbjad.apply {
            layoutManager = LinearLayoutManager(this@Glosarium)
            adapter = glosariumAdapter
        }
    }

    private fun parseJSON(): ArrayList<GlosariumData> {
        val employees = arrayListOf<GlosariumData>()
        var json: String? = null

        try {
            val input: InputStream = assets.open("data.json")
            json = input.bufferedReader().use { it.readText() }

            // Mengambil object terluar pada file JSON
            val jsonObject = JSONObject(json)

            // Mengambil array dengan kunci "employees" dari jsonObject
            val jsonArray = jsonObject.getJSONArray("data")

            // Melakukan perulangan untuk mengambil object employee dari jsonArray
            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)

                val abjad: String = jsonObj.getString("abjad")
                val isi = jsonObj.getJSONArray("isi")
                val child = arrayListOf<IsiData>()
                for (j in 0 until isi.length()) {
                    val jsonIsi = isi.getJSONObject(j)
                    val istilah: String = jsonIsi.getString("istilah")
                    val pengertian: String = jsonIsi.getString("pengertian")
                    val dataChild = IsiData(
                        istilah = istilah,
                        pengertian = pengertian
                    )
                    child.add(dataChild)
                }
                val dataAbjad = GlosariumData(
                    abjad = abjad,
                    isi = child
                )
                employees.add(dataAbjad)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return employees
    }
}