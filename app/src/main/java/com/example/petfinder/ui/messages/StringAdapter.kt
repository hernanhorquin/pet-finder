package com.example.petfinder.ui.messages


import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.petfinder.R

class StringAdapter: RecyclerView.Adapter<StringAdapter.ViewHolder>() {

    var list: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.profile_data_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(filterList: List<String>) {
        list.clear()
        list.addAll(filterList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var data: TextView = itemView.findViewById(R.id.item)

        fun bind(item: String) = with(itemView) {
            data.text = resources.getString(R.string.data_item, "  $item")
        }
    }
}