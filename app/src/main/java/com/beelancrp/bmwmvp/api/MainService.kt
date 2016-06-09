package com.beelancrp.bmwmvp.api

import com.beelancrp.bmwmvp.model.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService{

    @GET("/api/newslist")
    fun getNews(@Query("size") size: String, calback: Callback<List<MainModel>>): Call<List<MainModel>>
}
