package com.projects.enzoftware.krazyposts.di.component


import com.projects.enzoftware.krazyposts.di.module.ActivityModule
import com.projects.enzoftware.krazyposts.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}