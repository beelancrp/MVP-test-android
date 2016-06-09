package com.beelancrp.bmwmvp.interactors

import com.beelancrp.bmwmvp.api.MainService
import com.beelancrp.bmwmvp.interactors.interfaces.OnInteractorFinishListener
import com.beelancrp.bmwmvp.model.MainModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractor : Callback<List<MainModel>> {

    private var listener: OnInteractorFinishListener

    constructor(listener: OnInteractorFinishListener) {
        this.listener = listener
    }

    private fun initRetrofitAdapter(): Retrofit {
        val adapter: Retrofit = Retrofit.Builder()
                .baseUrl("http://app.awt.com.ua")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return adapter
    }

    fun loadNewsFromServer(size: String) {
        val adapter: Retrofit = initRetrofitAdapter()
        adapter.create(MainService::class.java).getNews(size, this)

    }

    override fun onResponse(call: Call<List<MainModel>>?, response: Response<List<MainModel>>?) {
        if (response!!.body() != null) {
            listener.onSuccess(response.body())
        }
    }

    override fun onFailure(call: Call<List<MainModel>>?, t: Throwable?) {
        listener.onError()
    }
}
