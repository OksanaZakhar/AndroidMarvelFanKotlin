package com.ksusha.vel.marvelfank.data.remotedata.servise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    private lateinit var retrofit: Retrofit
    private val BASE_URL = "https://gateway.marvel.com/"

    fun getService(): MarvelApiService {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MarvelApiService::class.java)
    }


}