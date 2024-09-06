package com.qtonz.adapter.advancerecycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.adapter.advancerecycleview.data.ListItem
import com.qtonz.adapter.databinding.ActivityAdvanceItemBinding
import com.qtonz.adapter.databinding.ActivityPracticeItemsBinding

class AdvanceAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ListItem.ItemOne -> 0
            is ListItem.ItemTwo -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = ActivityPracticeItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemOneViewHolder(binding)
            }
            1 -> {
                val binding = ActivityAdvanceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemTwoViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ListItem.ItemOne -> (holder as ItemOneViewHolder).bind(item.data)
            is ListItem.ItemTwo -> (holder as ItemTwoViewHolder).bind(item.data)
        }
    }

    override fun getItemCount(): Int = items.size
}
