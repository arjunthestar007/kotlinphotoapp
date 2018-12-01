package com.example.arjun.kotlinphotoapp.api

import com.example.arjun.kotlinphotoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

interface PhotoAPI {

    @GET("?key=10862021-edfc3d8b13519d27140e1eceb&q=yellow+flowers&image_type=photo")
    fun getPhotos():Call<PhotoList>
}