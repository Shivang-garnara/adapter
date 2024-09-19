package com.qtonz.adapter.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.qtonz.adapter.databinding.ItemNestedBinding
import com.qtonz.adapter.nestedrecyclerview.data.Items

class NestedRecyclerAdapter(private val mList: List<Items>) :
    RecyclerView.Adapter<NestedRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNestedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position], position)
    }

    inner class ViewHolder(val binding: ItemNestedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mList: Items, position: Int) {
            binding.imgTitie.setImageResource(mList.mainimage)
            binding.textView2.text = mList.text
            binding.imageView.setImageResource(mList.img1)
            binding.imgCenter.setImageResource(mList.img2)
            binding.imageView2.setImageResource(mList.img3)
            if (mList.boolean)
                binding.conCollaps.visibility = View.VISIBLE
            else
                binding.conCollaps.visibility = View.GONE
            binding.conTiltle.setOnClickListener {
                mList.boolean = !mList.boolean
                notifyItemChanged(position)
            }
            binding.conTiltle.setOnLongClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Long clicked on item: ${mList.text}",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
        }
    }
}