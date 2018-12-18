package com.projects.enzoftware.krazyposts.ui.about

import com.projects.enzoftware.krazyposts.ui.base.BaseContract

class AboutContract {

    interface View : BaseContract.View{
        fun showProgress(show: Boolean)
        fun loadMessageSuccess(message : String)
    }

    interface Presenter : BaseContract.Presenter<AboutContract.View>{
        fun loadMessage()
    }

}