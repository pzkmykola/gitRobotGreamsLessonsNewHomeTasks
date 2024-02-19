package com.example.gitrobotdreamsleesonsnewhomeasks

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
     @GET("/superhero-api/api/all.json")
     suspend fun getSuperHeroesByCR():SuperHeroDataResponse
}