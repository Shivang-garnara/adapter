package com.qtonz.adapter.nestedrecyclerview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qtonz.adapter.R
import com.qtonz.adapter.databinding.ActivityNestedRecyclerBinding
import com.qtonz.adapter.nestedrecyclerview.adapter.NestedRecyclerAdapter
import com.qtonz.adapter.nestedrecyclerview.data.Items

class NestedRecyclerActivity : AppCompatActivity() {
    private val binding: ActivityNestedRecyclerBinding by lazy {
        ActivityNestedRecyclerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val itemsList = listOf(Items(
            text = "Android",
            mainimage = R.drawable.icon,
            img1 = R.drawable.clip,
            img2 = R.drawable.clip,
            img3 = R.drawable.clip,
            boolean = false
        ), Items(
            text = "Ios",
            mainimage = R.drawable.icon,
            img1 = R.drawable.clip,
            img2 = R.drawable.clip,
            img3 = R.drawable.clip,
            boolean = false
        ),Items(
            text = "Flutter",
            mainimage = R.drawable.icon,
            img1 = R.drawable.clip,
            img2 = R.drawable.clip,
            img3 = R.drawable.clip,
            boolean = false
        ))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = NestedRecyclerAdapter(itemsList)
    }
}