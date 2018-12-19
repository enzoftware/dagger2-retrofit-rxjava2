package com.projects.enzoftware.krazyposts.di.module

import android.app.Application
import com.projects.enzoftware.krazyposts.BaseApp
import com.projects.enzoftware.krazyposts.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (private val baseApp: BaseApp){
    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application{
        return baseApp
    }
}