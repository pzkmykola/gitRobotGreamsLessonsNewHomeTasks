package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val api = ApiClient.client.create(ApiInterface::class.java)
//     Final solution for rick@morty site
// =========================================
        api.getSuperHeroes().enqueue(object : Callback<SuperHeroDataResponse> {
            override fun onResponse(
                call: Call<SuperHeroDataResponse>,
                response: Response<SuperHeroDataResponse>
            ) {
                if (response.isSuccessful) {
                    val items = response.body()?.data
                    val myAdapter = SuperheroViewAdapter(items as MutableList<SuperHero>) {
                        Toast.makeText(this@MainActivity, "$items clicked", Toast.LENGTH_LONG)
                            .show()
                    }
                    recyclerView.adapter = myAdapter
                }
            }

            override fun onFailure(call: Call<SuperHeroDataResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error $(t.message}", Toast.LENGTH_LONG)
                    .show()
            }
        })
// =========================================

//        Below is workable solution  for example on lesson16
//        It's necessary to uncomment code marked as "// this works" in other components
//================================================================
//        api.getSuperHeroes()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                if(it.data.superheroes != null){
//                    val items = it.data.superheroes
//                      val myAdapter = SuperheroViewAdapter(items as MutableList<SuperHero>){
//                          Toast.makeText(this, "$it clicked", Toast.LENGTH_LONG).show() }
//                    recyclerView.adapter = myAdapter
//                }
//            }) {
//                Toast.makeText(
//                    this,
//                    "Fetch error ${it.message} on response[${it}]",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
// ==================================================

        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

