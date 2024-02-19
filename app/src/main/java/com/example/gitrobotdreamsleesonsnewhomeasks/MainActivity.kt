package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fabAdd: FloatingActionButton = findViewById(R.id.fabButtonAdd)
        val fabRemove: FloatingActionButton = findViewById(R.id.fabButtonRemove)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        fabAdd.setOnClickListener {
            viewModel.getData()

        }

        fabRemove.setOnClickListener {
            viewModel.removeData()
        }

        viewModel.uiState.observe(this) {
            when (it) {
                is MyViewModel.UIState.Empty -> {
                    Toast.makeText(this, "List isEmpty. Click '+' button!", Toast.LENGTH_LONG).show()
                }

                is MyViewModel.UIState.Processing -> {
                    Toast.makeText(this, "Processing... .'-' button?", Toast.LENGTH_SHORT).show()
                }

                is MyViewModel.UIState.Result -> {
                    val myAdapter = SuperheroViewAdapter(it.list as MutableList<SuperHero>) {}
                    recyclerView.adapter = myAdapter
                }

                is MyViewModel.UIState.Clean -> {
                    val emptyList = mutableListOf<SuperHero>()
                    val myAdapter = SuperheroViewAdapter(emptyList) {}
                    recyclerView.adapter = myAdapter
                }
            }

        }
    }
}


