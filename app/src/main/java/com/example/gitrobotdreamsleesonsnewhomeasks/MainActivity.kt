package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitrobotdreamsleesonsnewhomeasks.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding.fabButtonAdd.setOnClickListener {
            viewModel.getData()

        }
        binding.fabButtonRemove.setOnClickListener {
            viewModel.removeData()
        }

        viewModel.uiState.observe(this) {
            when (it) {
                is MyViewModel.UIState.Empty -> {
                    Toast.makeText(this, "List isEmpty. Click '+' button!", Toast.LENGTH_SHORT).show()
                }

                is MyViewModel.UIState.Processing -> binding.progressBar.visibility = VISIBLE


                is MyViewModel.UIState.Result -> {
                    binding.progressBar.visibility = INVISIBLE
                    val myAdapter = SuperheroViewAdapter(it.list as MutableList<SuperHero>) {}
                    binding.recyclerView.adapter = myAdapter
                }

                is MyViewModel.UIState.Clean -> {
                    val emptyList = mutableListOf<SuperHero>()
                    val myAdapter = SuperheroViewAdapter(emptyList) {}
                    binding.recyclerView.adapter = myAdapter
                }
            }

        }
    }
}


