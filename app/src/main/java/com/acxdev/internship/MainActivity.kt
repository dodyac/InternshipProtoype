package com.acxdev.internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.viewpager.widget.ViewPager
import com.acxdev.commonFunction.adapter.PageAdapter
import com.acxdev.internship.databinding.ActivityMainBinding
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val page = PageAdapter(supportFragmentManager)
        page.adds(FragmentHome(), BlankFragment(), BlankFragment(), BlankFragment())
        binding.viewPager.adapter = page
        binding.viewPager.offscreenPageLimit = 4
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.bottomNav.menu.getItem(position).isChecked = true
                slideUp()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_home -> binding.viewPager.currentItem = 0
                R.id.navigation_applied -> binding.viewPager.currentItem = 1
                R.id.navigation_accepted -> binding.viewPager.currentItem = 2
                R.id.navigation_group -> binding.viewPager.currentItem = 3
            }
            slideUp()
            true
        }
    }

    private fun slideUp(){
        val layoutParams = binding.bottomNav.layoutParams as CoordinatorLayout.LayoutParams
        val bottomNavBehavior = layoutParams.behavior as HideBottomViewOnScrollBehavior
        bottomNavBehavior.slideUp(binding.bottomNav)
    }
}