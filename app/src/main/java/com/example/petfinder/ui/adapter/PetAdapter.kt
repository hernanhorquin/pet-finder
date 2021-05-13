package com.example.petfinder.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petfinder.R
import com.example.petfinder.data.model.Pet
import de.hdodenhof.circleimageview.CircleImageView

class PetAdapter(
    private val onPetClickListener: (Pet) -> Unit
) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    var list: MutableList<Pet> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.sub_breed_fragment_list_item, parent, false)
        return ViewHolder(view, onPetClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(filterList: List<Pet>) {
        list.clear()
        list.addAll(filterList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View, onPetClickListener: (Pet) -> Unit) : RecyclerView.ViewHolder(itemView) {
        var petName: TextView = itemView.findViewById(R.id.pet_name)
        var petYears: TextView = itemView.findViewById(R.id.pet_years)
        var petGender: TextView = itemView.findViewById(R.id.pet_gender)
        var petImage: CircleImageView = itemView.findViewById(R.id.pet_image)

        fun bind(item: Pet) = with(itemView) {
            petName.text = item.name
            Glide.with(this).load("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080").into(petImage)

            itemView.setOnClickListener {
                onPetClickListener(item)
            }
        }
    }
}
