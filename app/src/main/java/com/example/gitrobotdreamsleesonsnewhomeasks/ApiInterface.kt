package com.example.gitrobotdreamsleesonsnewhomeasks

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
//// @GET("/superhero-api/api/all.json") //this doesn't work
//   @GET("/get_memes") //this works
//   fun getSuperHeroes():Single<SuperHeroDataResponse>
   @GET("/api/character")  // final solution
   fun getSuperHeroes():Call<SuperHeroDataResponse>   // final solution
}