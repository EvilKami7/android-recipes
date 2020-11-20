package com.example.lesson_10.ui.mvp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson_10.R
import com.example.lesson_10.data.objects.Recipes

class CustomAdapter(private val list: Recipes, private val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.recipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = list.recipes.elementAt(position)
        holder.name.text = recipe.name
        holder.description.text = recipe.description
        Glide
            .with(holder.itemView)
            .load(recipe.images.elementAt(0))
            .into(holder.image)
        holder.itemLayout.setOnClickListener {
            //TODO поменять на иденификатор uuid
            onClick.invoke(position)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
        val description = view.findViewById<TextView>(R.id.description)
        val itemLayout = view.findViewById<ConstraintLayout>(R.id.itemLayout)
        val image = view.findViewById<ImageView>(R.id.imageView)
    }
}
