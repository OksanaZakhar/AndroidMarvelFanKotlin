package com.ksusha.vel.marvelfank.data.remotedata.repository


import androidx.lifecycle.MutableLiveData
import com.ksusha.vel.marvelfank.data.remotedata.model.MarvelApiResponse
import com.ksusha.vel.marvelfank.data.remotedata.model.Result
import com.ksusha.vel.marvelfank.data.remotedata.servise.MarvelApiService
import com.ksusha.vel.marvelfank.data.remotedata.servise.ParamsResponseKye
import com.ksusha.vel.marvelfank.data.remotedata.servise.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.NoSuchAlgorithmException

class MarvelRepository {

    val mutableLiveData: MutableLiveData<MutableList<Result>> = MutableLiveData()


    @Throws(NoSuchAlgorithmException::class)
    fun mutableLiveData() {
        val marvelApiService: MarvelApiService = RetrofitInstance().getService()
        val call = marvelApiService.getMarvel(
            10,
            ParamsResponseKye().getTimestamp(),
            ParamsResponseKye().API_KEY,
            ParamsResponseKye().getHash()
        )

        call.enqueue(object : Callback<MarvelApiResponse?> {
            override fun onResponse(
                call: Call<MarvelApiResponse?>,
                response: Response<MarvelApiResponse?>
            ) {
                if (response.isSuccessful) {
                    val marvelApiResponse = response.body()
                    if (marvelApiResponse != null) {
                        val results: MutableList<Result> = marvelApiResponse.data.results
                        mutableLiveData.value = results
                    }
                }
            }

            override fun onFailure(call: Call<MarvelApiResponse?>, t: Throwable) {}
        })

    }


    fun getMutableLiveDataMarvel(): MutableLiveData<MutableList<Result>> {
        mutableLiveData()
        return mutableLiveData
    }

}