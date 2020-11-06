package com.example.lesson_10.ui.mvp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_10.R
import com.example.lesson_10.data.objects.Recipe

class CustomAdapter(private val list: List<Recipe>, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = "test"
        holder.text2.text = "test"
        holder.itemLayout.setOnClickListener {
            //TODO поменять на иденификатор uuid
            onClick.invoke(position)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.textView)
        val text2 = view.findViewById<TextView>(R.id.textView2)
        val itemLayout = view.findViewById<ConstraintLayout>(R.id.itemLayout)

    }
}
