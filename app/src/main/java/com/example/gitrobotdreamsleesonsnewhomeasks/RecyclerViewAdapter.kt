package com.example.gitrobotdreamsleesonsnewhomeasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val items:MutableList<ListItem>, val onClick:(String)->Unit):RecyclerView.Adapter<RecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return RecyclerViewHolder(listItemView)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.itemView.setOnClickListener { onClick(items[position].title)}
    }
}

class  RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val title:TextView = itemView.findViewById(R.id.listTitle)
    val image:ImageView = itemView.findViewById(R.id.listImage)
}