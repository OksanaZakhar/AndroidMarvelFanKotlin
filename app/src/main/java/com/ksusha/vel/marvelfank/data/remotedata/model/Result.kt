package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result(id: String, name: String, description: String, thumbnail: Thumbnail, comics: Comics) {

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("description")
    @Expose
    var description: String = ""

    @SerializedName("thumbnail")
    @Expose
    lateinit var thumbnail: Thumbnail

    @SerializedName("comics")
    @Expose
    lateinit var comics: Comics


}