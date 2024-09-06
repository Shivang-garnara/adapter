package com.qtonz.adapter.practice.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.adapter.R
import com.qtonz.adapter.databinding.ActivityPracticeBinding
import com.qtonz.adapter.practice.adapter.PracticeAdapter
import com.qtonz.adapter.practice.data.itemsPractice

class PracticeActivity : AppCompatActivity() {
    private val data = ArrayList<itemsPractice>()
    val adapter = PracticeAdapter(data)
    private val binding: ActivityPracticeBinding by lazy {
        ActivityPracticeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
    }

    private fun setAdapter() {
        binding.mainRecycleView.layoutManager = LinearLayoutManager(this)
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )
        data.add(
            itemsPractice(
                R.drawable.ic_launcher_background,
                "vatar",
                "9",
                "hindi",
                "3h 15m 36s"
            )
        )

        binding.mainRecycleView.adapter = adapter
    }
}