package com.beelancrp.bmwmvp.model

import com.google.gson.annotations.SerializedName


class MainModel{

    @SerializedName("title")
    var title: String = ""

    @SerializedName("photos")
    lateinit var image: Array<String>
}
