package com.projects.enzoftware.krazyposts.ui.list

import com.projects.enzoftware.krazyposts.api.ApiServiceInterface
import com.projects.enzoftware.krazyposts.model.Album
import com.projects.enzoftware.krazyposts.model.DetailsViewModel
import com.projects.enzoftware.krazyposts.model.Post
import com.projects.enzoftware.krazyposts.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class ListPresenter :ListContract.Presenter{

    private val subscriptions = CompositeDisposable()
    private val api : ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view : ListContract.View

    override fun loadData() {
        val subscribe = api.getPostsList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({list : List<Post>? ->
                view.showProgress(false)
                view.loadDataSuccess(list!!.takeLast(10))
            },{error->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    override fun loadAllData() {
        val subscribe = Observable.zip(api.getPostsList(), api.getUsersList(), api.getAlbumsList(),
            Function3<List<Post>, List<User>, List<Album>, DetailsViewModel>{
            posts, users, albums ->
            createDetailsViewModel(posts,users,albums)
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({model: DetailsViewModel? ->
                view.showProgress(false)
                view.loadAllDataSuccess(model!!)
            },{error->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    override fun deleteItem(item: Post) {
        // TODO : IMPLEMENT DELETE
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    private fun createDetailsViewModel (posts : List<Post>, users : List<User>, albums : List<Album>): DetailsViewModel{
        val postList = posts.take(30)
        val userList = users.take(30)
        val albumList = albums.take(30)
        return DetailsViewModel(postList, userList, albumList)
    }
}