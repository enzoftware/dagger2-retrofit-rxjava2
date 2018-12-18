package com.projects.enzoftware.krazyposts.api

import com.projects.enzoftware.krazyposts.model.Album
import com.projects.enzoftware.krazyposts.model.Post
import com.projects.enzoftware.krazyposts.model.User
import com.projects.enzoftware.krazyposts.util.Constants
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("albums")
    fun getAlbumsList() : Observable<List<Album>>

    @GET("albums/{id}")
    fun getAlbum(@Path("id") id : Int) : Observable<Album>

    @DELETE("albums/{id}")
    fun deleteALbum(@Path("id") id : Int)

    @GET("posts")
    fun getPostsList() : Observable<List<Post>>

    @GET("posts/{id}")
    fun getPost(@Path("id") id : Int) : Observable<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id : Int)

    @GET("users")
    fun getUsersList() : Observable<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") id : Int) : Observable<User>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id : Int)

    companion object Factory{
        fun create() : ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return  retrofit.create(ApiServiceInterface::class.java)
        }
    }
}