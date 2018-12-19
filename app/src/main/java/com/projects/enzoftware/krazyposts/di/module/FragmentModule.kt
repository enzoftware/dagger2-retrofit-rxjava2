package com.projects.enzoftware.krazyposts.di.module

import com.projects.enzoftware.krazyposts.api.ApiServiceInterface
import com.projects.enzoftware.krazyposts.ui.about.AboutContract
import com.projects.enzoftware.krazyposts.ui.about.AboutPresenter
import com.projects.enzoftware.krazyposts.ui.list.ListContract
import com.projects.enzoftware.krazyposts.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {

    @Provides
    fun provideAboutPresenter(): AboutContract.Presenter{
        return AboutPresenter()
    }

    @Provides
    fun provideListPresenter(): ListContract.Presenter{
        return ListPresenter()
    }

    @Provides
    fun provideApiService(): ApiServiceInterface{
        return ApiServiceInterface.create()
    }
}