package com.sample.demo.tablayout.page

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.sample.demo.tablayout.adapter.ParksAdapter
import com.sample.demo.tablayout.R
import com.sample.demo.tablayout.unit.DateUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ParksAdapter
    private var mPosition: Int = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        supportActionBar?.title = "線上測驗A"
        button.text = "切換分頁2"
        adapter = ParksAdapter(supportFragmentManager)
        tabs.addTab(tabs.newTab().setText("分頁1"))
        tabs.addTab(tabs.newTab().setText("分頁2"))
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewpager))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mPosition = tab.position
                if (tab.position == 1) {
                    supportActionBar?.title = "線上測驗B"
                    button.text = "切換分頁1"
                } else {
                    supportActionBar?.title = "線上測驗A"
                    button.text = "切換分頁2"
                }
                viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        button.setOnClickListener(View.OnClickListener {

            if (mPosition == 0) {
                viewpager.currentItem = 1
                button.text = "切換分頁1"
            } else {
                viewpager.currentItem = 0
                button.text = "切換分頁2"
            }
        })
    }


}
