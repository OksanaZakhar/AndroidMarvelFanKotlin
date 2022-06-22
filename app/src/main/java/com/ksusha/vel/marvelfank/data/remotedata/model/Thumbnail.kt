package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Thumbnail(path: String, extension: String) {

    @SerializedName("path")
    @Expose
    var path: String = ""

    @SerializedName("extension")
    @Expose
    var extension: String = ""
}