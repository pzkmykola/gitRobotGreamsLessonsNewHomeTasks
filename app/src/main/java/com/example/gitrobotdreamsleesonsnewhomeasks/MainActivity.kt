package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayListOf<ListItem>()
        repeat(100){
            items.add(ListItem("", "Element #$it"))
        }
        val listView:ListView = findViewById(R.id.listView)
    }
}

data class ListItem(val image:String, val title:String)