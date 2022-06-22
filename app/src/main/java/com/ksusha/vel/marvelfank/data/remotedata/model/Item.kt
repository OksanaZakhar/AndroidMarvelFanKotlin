package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item(name: String) {

    @SerializedName("name")
    @Expose
    var name: String = ""


}