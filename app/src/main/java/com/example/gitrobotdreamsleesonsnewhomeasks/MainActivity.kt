package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayListOf<ListItem>()
        repeat(100){
            items.add(ListItem("", "Element #$it"))
        }
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
//        val myAdapter = RecyclerViewAdapter(items, onClick = {
//            Toast.makeText(this, "$it clicked", Toast.LENGTH_SHORT).show()
//        })

        //lambda as last param moved out from()
        val myAdapter = RecyclerViewAdapter(items) {
            Toast.makeText(this, "$it clicked", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}

data class ListItem(val image:String, val title:String)