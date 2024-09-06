package com.qtonz.adapter.advancerecycleview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.qtonz.adapter.databinding.ActivityPracticeItemsBinding
import com.qtonz.adapter.advancerecycleview.data.ItemsMoive

class ItemOneViewHolder(private val binding: ActivityPracticeItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemsMoive) {
        binding.imgMovie.setImageResource(item.img)
        binding.tvMovieName.text = item.moviename
        binding.tvRate.text = item.rating
        binding.tvLanguage.text = item.language
        binding.tvMovieTime.text = item.time
    }
}
