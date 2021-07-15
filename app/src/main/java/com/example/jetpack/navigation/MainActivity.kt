package com.example.jetpack.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 这里我认为 homeFragment infoFragment myFragment 分别对应一个 navigation.xml 文件做去导航
         * 分别控制他们名下的一些 Fragment 的跳转
         * 这样做的好处是：跳转逻辑不耦合，各做各的跳转，避免回退逻辑的错误
         */
        bottomNavView.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.bottom_nav_home -> {
                    setNewNavGraph(R.navigation.nav_home)
                    true
                }
                R.id.bottom_nav_info -> {
                    setNewNavGraph(R.navigation.nav_info)
                    true
                }
                R.id.bottom_nav_my -> {
                    setNewNavGraph(R.navigation.nav_my)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setNewNavGraph(navId: Int) {
        findNavController(R.id.nav_host_fragment).setGraph(navId)
    }
}