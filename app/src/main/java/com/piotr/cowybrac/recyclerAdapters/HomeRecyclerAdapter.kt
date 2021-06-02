package com.piotr.cowybrac.recyclerAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.piotr.cowybrac.R
import com.piotr.cowybrac.retrofit.rest.restModel.Compare

class HomeRecyclerAdapter(): RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {
    private var list: MutableList<Compare> = ArrayList()
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val description1 = itemView.findViewById<TextView>(R.id.description1)
        val description2 = itemView.findViewById<TextView>(R.id.description2)

        val image1 = itemView.findViewById<ImageView>(R.id.image1)
        val image2 = itemView.findViewById<ImageView>(R.id.image2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.home_row, parent, false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.description1.text = list[position].firstUrl
        holder.description2.text = list[position].secondUrl
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setData(newList: List<Compare>){
        list.addAll(newList)
        notifyItemRangeChanged(list.size, newList.size)
    }
}