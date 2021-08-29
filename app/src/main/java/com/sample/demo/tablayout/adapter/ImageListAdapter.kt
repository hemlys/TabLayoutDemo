package com.sample.demo.tablayout.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.tablayout.R

class ImageListAdapter(movieList: List<String>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    var list = movieList


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var rootView = View.inflate(parent.context, R.layout.grid_item, null)

        return ViewHolder(rootView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadImage(position)
    }

    inner class ViewHolder(var rootView: View) : RecyclerView.ViewHolder(rootView) {


        fun loadImage(position: Int) {
            var title = rootView.findViewById(R.id.text) as TextView
            var  adapter=this@ImageListAdapter
            title.text=adapter.list.get(position)
        }
    }
}