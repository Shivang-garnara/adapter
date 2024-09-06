package com.qtonz.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qtonz.adapter.advancerecycleview.activity.AdvanceActivity
import com.qtonz.adapter.simple.activity.MainSimpleActivity
import com.qtonz.adapter.databinding.ActivityMainAppBinding
import com.qtonz.adapter.animated.flowerList.FlowersListActivity
import com.qtonz.adapter.nestedrecyclerview.activity.NestedRecyclerActivity
import com.qtonz.adapter.practice.activity.PracticeActivity
import com.qtonz.adapter.recycle.activity.BasicRecycleViewActivity

class MainAppActivity : AppCompatActivity(), View.OnClickListener {
    private val binding:ActivityMainAppBinding by lazy {
        ActivityMainAppBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addListener()
    }

    private fun addListener() {
        binding.btnSimpleAdapter.setOnClickListener(this)
        binding.btnRecycleView.setOnClickListener(this)
        binding.btnPractice.setOnClickListener(this)
        binding.btnadvanceRecycleView.setOnClickListener(this)
        binding.btnAnimatedAdapter.setOnClickListener(this)
        binding.btnnestedRecycleView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnSimpleAdapter ->{
                startActivity(Intent(this@MainAppActivity, MainSimpleActivity::class.java))
            }
            R.id.btnRecycleView ->{
                startActivity(Intent(this@MainAppActivity, BasicRecycleViewActivity::class.java))
            }
            R.id.btnPractice ->{
                startActivity(Intent(this@MainAppActivity, PracticeActivity::class.java))
            }
            R.id.btnnestedRecycleView->{
                startActivity(Intent(this@MainAppActivity, NestedRecyclerActivity::class.java))
            }
            R.id.btnadvanceRecycleView ->{
                startActivity(Intent(this@MainAppActivity, AdvanceActivity::class.java))
            }
            R.id.btnAnimatedAdapter ->{
                startActivity(Intent(this@MainAppActivity, FlowersListActivity::class.java))
            }
        }
    }
}