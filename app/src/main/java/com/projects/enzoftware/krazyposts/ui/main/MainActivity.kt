package com.projects.enzoftware.krazyposts.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.projects.enzoftware.krazyposts.R
import com.projects.enzoftware.krazyposts.di.component.DaggerActivityComponent
import com.projects.enzoftware.krazyposts.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject lateinit var presenter : MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }



    override fun showAboutFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showListFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    enum class AnimType() {
        SLIDE,
        FADE;


    }

}
