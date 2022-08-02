package com.example.biologi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.biologi.R
import com.example.biologi.data.GlosariumData
import kotlinx.android.synthetic.main.list_abjad.view.*

class RecyclerviewGlosariumAdapter(private val glosarium: List<GlosariumData>) :
    RecyclerView.Adapter<GlosariumHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlosariumHolder {
        return GlosariumHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_abjad,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GlosariumHolder, position: Int) {
        holder.bindGlosarium(glosarium[position])

    }

    override fun getItemCount(): Int {
        return glosarium.size
    }
}

class GlosariumHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val abjad = view.listItemAbjadTextView
    private val recyclerViewIsi = view.isiListView

    fun bindGlosarium(glosarium: GlosariumData) {
        abjad.text = glosarium.abjad
        val recyclerViewChildAdapter: RecyclerViewChildAdapter? =
            glosarium.isi?.let { RecyclerViewChildAdapter(it) }
        recyclerViewIsi.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewChildAdapter
        }
    }

}
