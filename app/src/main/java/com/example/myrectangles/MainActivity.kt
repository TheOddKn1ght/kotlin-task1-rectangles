package com.example.myrectangles

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private val items = mutableListOf<Item>()
private lateinit var itemAdapter: MainAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.recyclerView)
        val addButton : Button = findViewById(R.id.addButton)

        val layoutManager = GridLayoutManager(this, getSpanCount())
        rv.layoutManager = layoutManager

        itemAdapter = MainAdapter(items)
        rv.adapter = itemAdapter

        addButton.setOnClickListener {
            val newItem = Item(items.size, items.size % 2 == 0)
            items.add(newItem)
            itemAdapter.notifyItemInserted(items.size - 1)
        }
    }

    private fun getSpanCount(): Int{
        val orientation = resources.configuration.orientation
        return if (orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3
    }

}