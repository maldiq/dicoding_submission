package com.nizamapp.dicodingsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListRaiderAdapter (private var listRaider: ArrayList<Raider>): RecyclerView.Adapter<ListRaiderAdapter.ListViewHolder>() {

    private lateinit var onItemClickcallback: OnItemClickcallback

    fun setOnItemClickCallback(onItemClickcallback: OnItemClickcallback) {
        this.onItemClickcallback = onItemClickcallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvType: TextView = itemView.findViewById(R.id.tv_item_type)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_raider, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val raider = listRaider[position]

        holder.tvName.text = "Kamen Rider " + raider.name
        holder.tvType.text = raider.type

        Glide.with(holder.itemView.context)
            .load(raider.photo)
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener { onItemClickcallback.onItemClicked(listRaider[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int = listRaider.size

    interface OnItemClickcallback {
        fun onItemClicked(raider: Raider)
    }
}