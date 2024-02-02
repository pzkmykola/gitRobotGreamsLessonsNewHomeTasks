package com.example.gitrobotdreamsleesonsnewhomeasks

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private val httpClient = OkHttpClient.Builder()
            .addInterceptor(CustomInterceptor())
            .build()
        val client: Retrofit = Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://rickandmortyapi.com/")
            //.baseUrl("https://api.imgflip.com/")
            //.baseUrl(/* baseUrl = */ "https://akabab.github.io/superhero-api/api/")
            .build()
    }
}