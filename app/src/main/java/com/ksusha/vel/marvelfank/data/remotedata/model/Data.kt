package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data (results: MutableList<Result>) {

    @SerializedName("results")
    @Expose
    lateinit var results: MutableList<Result>

}