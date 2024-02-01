package com.example.gitrobotdreamsleesonsnewhomeasks

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
   @GET("/get_memes")
    fun getMemes():Single<MemesResponse>
}