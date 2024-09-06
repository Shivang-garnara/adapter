package com.qtonz.adapter.recycle.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.adapter.R
import com.qtonz.adapter.databinding.ActivityBasicRecycleViewBinding
import com.qtonz.adapter.recycle.adapter.CustomAdapter
import com.qtonz.adapter.recycle.data.Items

class BasicRecycleViewActivity : AppCompatActivity() {
    val data = ArrayList<Items>()
    val adapter = CustomAdapter(data)
    private val binding: ActivityBasicRecycleViewBinding by lazy {
        ActivityBasicRecycleViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
    }

    private fun setAdapter() {
        binding.recycleData.layoutManager = LinearLayoutManager(this)
        for (i in 1..20) {
            data.add(Items(R.drawable.ic_launcher_background, "Item $i"))
        }
        binding.recycleData.adapter = adapter
    }
}