package com.beelancrp.bmwmvp.view

import com.beelancrp.bmwmvp.model.MainModel


interface IMainView{

    fun onNewsLoaded(list: List<MainModel>)
    fun onMoreNewsLoaded()
    fun onLoadError()
}