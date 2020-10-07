package org.gwnu.tutorial.retrofit2

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    @GET("posts")
    fun searchPhotos(@Query("query") searchTerm: String): Call<JsonElement>

    @GET("search/users")
    fun searchUsers(@Query("query") searchTerm: String): Call<JsonElement>

}