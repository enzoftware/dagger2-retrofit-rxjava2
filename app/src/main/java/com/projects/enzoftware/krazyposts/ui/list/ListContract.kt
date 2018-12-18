package com.projects.enzoftware.krazyposts.ui.list

import com.projects.enzoftware.krazyposts.model.DetailsViewModel
import com.projects.enzoftware.krazyposts.model.Post
import com.projects.enzoftware.krazyposts.ui.base.BaseContract

class ListContract {
    interface View : BaseContract.View{
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Post>)
        fun loadAllDataSuccess(model: DetailsViewModel)
    }

    interface Presenter : BaseContract.Presenter<ListContract.Presenter>{
        fun loadData()
        fun loadAllData()
        fun deleteItem(item : Post)
    }
}