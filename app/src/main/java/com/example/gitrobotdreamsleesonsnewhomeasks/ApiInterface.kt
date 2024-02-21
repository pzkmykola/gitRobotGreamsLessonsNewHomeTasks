package com.example.gitrobotdreamsleesonsnewhomeasks

import retrofit2.http.GET

interface ApiInterface {
     @GET("/superhero-api/api/all.json")
     suspend fun getSuperHeroesByCR():SuperHeroDataResponse
}