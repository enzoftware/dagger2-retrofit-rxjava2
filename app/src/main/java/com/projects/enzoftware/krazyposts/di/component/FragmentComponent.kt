package com.projects.enzoftware.krazyposts.di.component


import com.projects.enzoftware.krazyposts.di.module.FragmentModule
import com.projects.enzoftware.krazyposts.ui.about.AboutFragment
import com.projects.enzoftware.krazyposts.ui.list.ListFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)

}