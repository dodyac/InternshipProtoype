package com.acxdev.internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.acxdev.commonFunction.adapter.PageAdapter
import com.acxdev.commonFunction.util.FunctionX.Companion.useCurrentTheme
import com.acxdev.internship.databinding.ActivityOnBoardingBinding

class ActivityOnBoarding : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        useCurrentTheme()
        val page = PageAdapter(supportFragmentManager)
        page.adds(FragmentOnBoarding(), FragmentOnBoarding(), FragmentOnBoarding())
        binding.viewPager.adapter = page
        binding.dotsIndicator.setViewPager(binding.viewPager)
        var current = 0
        binding.next.setOnClickListener {
            if(current<2){
                current+=1
                binding.viewPager.currentItem = current
            }
            else{
                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> current = 0
                    1 -> current = 1
                    2 -> current = 2
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }
}