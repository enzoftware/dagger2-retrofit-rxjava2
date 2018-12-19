package com.projects.enzoftware.krazyposts.di.component

import com.projects.enzoftware.krazyposts.BaseApp
import com.projects.enzoftware.krazyposts.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: BaseApp)
}