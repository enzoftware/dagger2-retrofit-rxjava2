package com.projects.enzoftware.krazyposts

import android.app.Application
import com.projects.enzoftware.krazyposts.di.component.ApplicationComponent
import com.projects.enzoftware.krazyposts.di.component.DaggerApplicationComponent
import com.projects.enzoftware.krazyposts.di.module.ApplicationModule


class BaseApp: Application() {
    lateinit var component : ApplicationComponent

    companion object {
        lateinit var instance : BaseApp private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
        if (BuildConfig.DEBUG){

        }
    }

    private fun setup(){
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent{
        return component
    }
}