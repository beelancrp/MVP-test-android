package com.beelancrp.bmwmvp.presenter

import com.beelancrp.bmwmvp.interactors.MainInteractor
import com.beelancrp.bmwmvp.interactors.interfaces.OnInteractorFinishListener
import com.beelancrp.bmwmvp.model.MainModel
import com.beelancrp.bmwmvp.presenter.interfaces.ImainPresenter
import com.beelancrp.bmwmvp.view.IMainView

class MainPresenter: ImainPresenter, OnInteractorFinishListener {

    private val view: IMainView

    private val interactor: MainInteractor
    constructor(view: IMainView) {
        this.view = view
        this.interactor = MainInteractor(this)
    }

    override fun loadMoreNews() {
        throw UnsupportedOperationException()
    }

    override fun loadNews() {
        interactor.loadNewsFromServer("0")
    }

    override fun onSuccess(list: List<MainModel>) {
        view.onNewsLoaded(list)
    }

    override fun onError() {
        view.onLoadError()
    }
}
