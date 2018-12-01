package com.example.arjun.kotlinphotoapp.api

import com.example.arjun.kotlinphotoapp.models.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PhotoRetriever {

    val service:PhotoAPI

    init {
        val retrofit=Retrofit.Builder().baseUrl("https://pixabay.com/api/").addConverterFactory(GsonConverterFactory.create()).build()

        service=retrofit.create(PhotoAPI::class.java)
    }

    fun getphotos(callback:Callback<PhotoList>){
        val call=service.getPhotos()
        call.enqueue(callback)
    }

}