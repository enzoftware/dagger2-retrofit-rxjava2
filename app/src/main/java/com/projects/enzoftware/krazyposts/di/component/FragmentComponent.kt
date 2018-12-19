package com.projects.enzoftware.krazyposts.di.component


import com.projects.enzoftware.krazyposts.di.module.FragmentModule
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(aboutFragment: AboutFragment)

    fun inject(listFragment: ListFragment)

}