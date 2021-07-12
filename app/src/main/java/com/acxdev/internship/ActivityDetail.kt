package com.acxdev.internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.acxdev.commonFunction.adapter.PageAdapter
import com.acxdev.commonFunction.util.FunctionX.Companion.putExtra
import com.acxdev.commonFunction.util.FunctionX.Companion.useCurrentTheme
import com.acxdev.internship.databinding.ActivityDetailBinding
import com.google.gson.Gson

class ActivityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        useCurrentTheme()
        binding.back.setOnClickListener { onBackPressed() }

        val data = Gson().fromJson(intent.getStringExtra(Constant.DATA), Job::class.java)

        binding.image.setImageResource(data.image)
        binding.title.text = data.title
        binding.duration.text = "${data.duration} /"
        binding.location.text = data.location

        val page = PageAdapter(supportFragmentManager)
        page.addWithTitle(FragmentDescription().putExtra(Gson().toJson(data)), getString(R.string.descriptions))
        page.addWithTitle(BlankFragment(), getString(R.string.aboutCompany))
        binding.viewPager.adapter = page
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}