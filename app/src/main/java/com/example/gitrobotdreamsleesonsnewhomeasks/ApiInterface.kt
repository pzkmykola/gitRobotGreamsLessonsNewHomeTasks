package com.example.gitrobotdreamsleesonsnewhomeasks

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
   //@GET("/all.json")
   //@GET("/get_memes")
   @GET("/api/character")
   fun getSuperHeroes():Call<SuperHeroDataResponse>
}