package com.sample.demo.tablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sample.demo.tablayout.fragment.Park1Fragment
import com.sample.demo.tablayout.fragment.Park2Fragment



class ParksAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return Park1Fragment()
            else -> return Park2Fragment()

        }

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> return "分頁1"
            else -> return "分頁2"

        }
    }

}