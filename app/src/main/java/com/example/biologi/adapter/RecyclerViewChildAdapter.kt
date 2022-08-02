package com.example.biologi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.biologi.R
import com.example.biologi.data.IsiData
import kotlinx.android.synthetic.main.list_isi.view.*

class RecyclerViewChildAdapter(private val child: List<IsiData>) :
    RecyclerView.Adapter<ChildHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        return ChildHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_isi,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        holder.bindChild(child[position])
    }

    override fun getItemCount(): Int {
        return child.size
    }
}

class ChildHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val istilah = view.istilahTextView
    private val pengertian = view.pengertianTekview
    fun bindChild(child: IsiData) {
        istilah.text = child.istilah
        pengertian.text = child.pengertian
    }

}
