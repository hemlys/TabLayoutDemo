package com.sample.demo.tablayout.fragment


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.demo.tablayout.R
import com.sample.demo.tablayout.adapter.ImageListAdapter
import com.sample.demo.tablayout.unit.DateUtils
import kotlinx.android.synthetic.main.fragment_park1.*


class Park1Fragment() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_park1, container, false)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mDateUtils: DateUtils = DateUtils()
        val dayday = mDateUtils.get7week()
        val lists = ArrayList<String>()
        for (i in 0 until (dayday?.size ?: 0)) {
            val k = i + 1
            lists.add("項目" + k + " " + dayday?.get(i))
        }



        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = ImageListAdapter(lists)
    }


}
