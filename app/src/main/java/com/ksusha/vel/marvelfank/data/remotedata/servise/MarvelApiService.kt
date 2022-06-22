package com.ksusha.vel.marvelfank.data.remotedata.servise

import com.ksusha.vel.marvelfank.data.remotedata.model.MarvelApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("v1/public/characters")
    fun getMarvel(
        @Query("limit") limit: Int,
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Call<MarvelApiResponse>

}