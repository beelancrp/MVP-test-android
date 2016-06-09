package com.beelancrp.bmwmvp.interactors.interfaces

import com.beelancrp.bmwmvp.model.MainModel
import retrofit2.Response

/**
 * Created by zatsniyvlad on 6/9/16.
 */
interface OnInteractorFinishListener {
    fun onSuccess(list: List<MainModel>)
    fun onError()
}