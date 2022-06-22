package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MarvelApiResponse(data: Data) {

    @SerializedName("data")
    @Expose
    lateinit var data: Data

}