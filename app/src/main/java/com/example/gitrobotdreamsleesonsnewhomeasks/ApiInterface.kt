package com.example.gitrobotdreamsleesonsnewhomeasks

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
     @GET("/superhero-api/api/all.json")
     fun getSuperHeroes():Single<SuperHeroDataResponse>
//   // final solution
//  fun getSuperHeroes():Call<SuperHeroDataResponse>   // final solution
}