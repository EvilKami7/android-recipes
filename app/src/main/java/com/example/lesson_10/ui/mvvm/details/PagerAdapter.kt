package com.example.lesson_10.ui.mvvm.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.lesson_10.R
import com.example.lesson_10.ui.mvp.main.CustomAdapter

class PagerAdapter(private val list: List<String>):
    RecyclerView.Adapter<PagerAdapter.PagerVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.image_list, parent, false
        )
        return PagerAdapter.PagerVH(view)
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        Glide
            .with(holder.itemView)
            .load(list.elementAt(position))
            .into(holder.image)
    }

    override fun getItemCount(): Int = list.size

    class PagerVH(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView2)
    }

}