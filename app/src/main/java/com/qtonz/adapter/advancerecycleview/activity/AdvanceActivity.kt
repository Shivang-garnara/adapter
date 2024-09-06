package com.qtonz.adapter.advancerecycleview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.adapter.R
import com.qtonz.adapter.advancerecycleview.adapter.AdvanceAdapter
import com.qtonz.adapter.advancerecycleview.data.ItemsMoive
import com.qtonz.adapter.advancerecycleview.data.ItemsSeries
import com.qtonz.adapter.advancerecycleview.data.ListItem
import com.qtonz.adapter.databinding.ActivityAdvanceBinding

class AdvanceActivity : AppCompatActivity() {
    private val binding: ActivityAdvanceBinding by lazy {
        ActivityAdvanceBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val items = listOf(
            ListItem.ItemOne(
                ItemsMoive(
                    R.drawable.ic_launcher_background,
                    "Movie 1",
                    "8.5",
                    "English",
                    "2h 30m"
                )
            ),
            ListItem.ItemTwo(
                ItemsSeries(
                    R.drawable.ic_launcher_background,
                    "Movie 2",
                    "7.8",
                    "English",
                    "3h",
                    "Series 1"
                )
            ),
            ListItem.ItemTwo(
                ItemsSeries(
                    R.drawable.ic_launcher_background,
                    "Movie 2",
                    "7.8",
                    "English",
                    "3h",
                    "Series 1"
                )
            )
        )
        binding.advanceRecycleView.layoutManager = LinearLayoutManager(this)
        binding.advanceRecycleView.adapter = AdvanceAdapter(items)
    }
}