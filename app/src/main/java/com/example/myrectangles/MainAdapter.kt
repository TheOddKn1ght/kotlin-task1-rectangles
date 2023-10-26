package com.example.myrectangles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val items: List<Item>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val itemNumber: TextView = itemView.findViewById(R.id.itemNumber)

        fun bind(item: Item) {
            itemNumber.text = item.number.toString()
            itemNumber.setBackgroundResource(if (item.isEven) R.color.even_color else R.color.odd_color)
        }
    }


}