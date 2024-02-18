package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val api = ApiClient.client.create(ApiInterface::class.java)

        api.getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                if(it!= null){
                    val items = it
                      val myAdapter = SuperheroViewAdapter(items as MutableList<SuperHero>){
                          Toast.makeText(this, buildString {
                                    append(it)
                                    append(" clicked now")
                                },
                              Toast.LENGTH_LONG).show() }
                    recyclerView.adapter = myAdapter
                }
            }) {
                Toast.makeText(
                    this,
                    "Fetch error ${it.message} on response]",
                    Toast.LENGTH_LONG
                ).show()
            }

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

