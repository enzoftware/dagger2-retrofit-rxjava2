package com.projects.enzoftware.krazyposts.di.module

import android.app.Activity
import com.projects.enzoftware.krazyposts.ui.main.MainContract
import com.projects.enzoftware.krazyposts.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity){
    @Provides
    fun provideActivity() : Activity{
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter{
        return MainPresenter()
    }
}