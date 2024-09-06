package com.qtonz.adapter.simple.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.qtonz.adapter.databinding.ActivityMainSimpleBinding

class MainSimpleActivity : AppCompatActivity() {
    private val binding:ActivityMainSimpleBinding by lazy {
        ActivityMainSimpleBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val list = ArrayList<String>()
        list.add("shivang")
        list.add("jay")
        list.add("darshan")
        list.add("anil")
        list.add("vipul")
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item,list)
        binding.simpleSpinerTest.adapter = aa
    }
}