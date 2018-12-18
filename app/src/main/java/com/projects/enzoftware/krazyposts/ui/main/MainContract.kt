package com.projects.enzoftware.krazyposts.ui.main

import com.projects.enzoftware.krazyposts.ui.base.BaseContract

class MainContract {

    interface View : BaseContract.View{
        fun showAboutFragment()
        fun showListFragment()
    }

    interface Presenter : BaseContract.Presenter<MainContract.View>{
        fun onDrawerOptionAboutClick()
    }
}