package com.qtonz.adapter.roomrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qtonz.adapter.databinding.ActivityMainRoomrecyclerBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainRoomrecyclerBinding by lazy {
        ActivityMainRoomrecyclerBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addListener()
    }
    private fun addListener() {
    }

}
