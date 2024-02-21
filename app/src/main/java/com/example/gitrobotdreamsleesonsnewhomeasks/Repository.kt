package com.example.gitrobotdreamsleesonsnewhomeasks

import javax.inject.Singleton

@Singleton
class Repository (val apiClient: ApiClient) {
        suspend fun getSuperHeroesByCR() : SuperHeroDataResponse{
        val apiInterfase = apiClient.client.create(ApiInterface::class.java)
        return apiInterfase.getSuperHeroesByCR()
    }
}