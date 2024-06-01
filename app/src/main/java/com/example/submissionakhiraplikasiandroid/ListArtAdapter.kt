package com.example.submissionakhiraplikasiandroid

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionakhiraplikasiandroid.databinding.ActivityMainBinding
import com.example.submissionakhiraplikasiandroid.databinding.ItemRowArtBinding

class ListArtAdapter(private val listArt: ArrayList<Art>,
                     private val listener: (Art) -> Unit)
    :RecyclerView.Adapter<ListArtAdapter.ListViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val binding = ItemRowArtBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ListViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return listArt.size
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val (title, description, photo, created, location ) = listArt[position]
            holder.apply {
                binding.apply {
                    imgItemPhoto.setImageResource(photo)
                    tvItemTitle.text = title
                    tvItemDescription.text = description
                    itemView.setOnClickListener { listener(listArt[position])}

                }
            }
//            holder.itemView.setOnClickListener {listener(listArt[position])}
//            holder.binding.imgItemPhoto.setImageResource(photo)
//            holder.binding.tvItemTitle.text = title
//            holder.binding.tvItemDescription.text = description
        }
    class ListViewHolder(val binding: ItemRowArtBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}