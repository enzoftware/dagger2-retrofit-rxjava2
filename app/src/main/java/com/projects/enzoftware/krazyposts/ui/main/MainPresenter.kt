package com.projects.enzoftware.krazyposts.ui.main

import io.reactivex.disposables.CompositeDisposable

class MainPresenter : MainContract.Presenter {

    private lateinit var view : MainContract.View
    private val subscriptions = CompositeDisposable()

    override fun onDrawerOptionAboutClick() {
        view.showAboutFragment()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showListFragment() //as default
    }
}