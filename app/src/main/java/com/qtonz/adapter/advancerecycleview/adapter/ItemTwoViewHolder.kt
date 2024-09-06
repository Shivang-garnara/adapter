package com.qtonz.adapter.advancerecycleview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.qtonz.adapter.databinding.ActivityAdvanceItemBinding
import com.qtonz.adapter.advancerecycleview.data.ItemsMoive
import com.qtonz.adapter.advancerecycleview.data.ItemsSeries

class ItemTwoViewHolder(private val binding: ActivityAdvanceItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemsSeries) {
        binding.imgMovie.setImageResource(item.img)
        binding.tvMovieName.text = item.moviename
        binding.tvRate.text = item.rating
        binding.tvLanguage.text = item.language
        binding.tvMovieTime.text = item.time
    }
}
