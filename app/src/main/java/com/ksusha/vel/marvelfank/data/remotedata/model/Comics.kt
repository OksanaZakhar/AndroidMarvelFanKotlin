package com.ksusha.vel.marvelfank.data.remotedata.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comics(items: MutableList<Item>) {

    @SerializedName("items")
    @Expose
    lateinit var items: MutableList<Item>

}