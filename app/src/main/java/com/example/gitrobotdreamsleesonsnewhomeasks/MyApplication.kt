package com.example.gitrobotdreamsleesonsnewhomeasks

import android.app.Application
import retrofit2.Retrofit

class MyApplication : Application() {
    lateinit var repo: Repository
    override fun onCreate() {
        super.onCreate()
        instance = this
        repo = Repository(getApiClient())
    }
    private fun getApiClient(): Retrofit {
        return ApiClient().client
    }
    companion object {
        private lateinit var instance: MyApplication
        fun getApp() = instance
    }
}