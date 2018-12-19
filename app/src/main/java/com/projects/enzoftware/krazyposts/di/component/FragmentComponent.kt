package com.projects.enzoftware.krazyposts.di.component

import android.support.v4.app.ListFragment
import com.projects.enzoftware.krazyposts.di.module.FragmentModule
import com.projects.enzoftware.krazyposts.ui.about.AboutFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)

}