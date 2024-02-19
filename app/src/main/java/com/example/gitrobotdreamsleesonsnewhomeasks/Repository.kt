package com.example.gitrobotdreamsleesonsnewhomeasks

import retrofit2.Retrofit

class Repository (private val client: Retrofit) {
        suspend fun getSuperHeroesByCR() : SuperHeroDataResponse{
        val apiInterfase = client.create(ApiInterface::class.java)
        return apiInterfase.getSuperHeroesByCR()
    }
}