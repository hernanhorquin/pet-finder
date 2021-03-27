package com.example.petfinder.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petfinder.R

class PetImageAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<PetImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var petImage: ImageView = itemView.findViewById(R.id.pet_image)
        fun bind(item: String) = with(itemView) {
            //Glide.with(itemView).load("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=980:*").into(petImage)
            Glide.with(this)
                .load("https://moodle.htwchur.ch/pluginfile.php/124614/mod_page/content/4/example.jpg")
                .into(petImage)
        }

    }
}