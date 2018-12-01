package com.example.arjun.kotlinphotoapp.models

import java.io.Serializable

data class Photo(val id:String,val likes:Int,val favorites:Int  ,val tags:String,val previewURL:String,val weburl:String):Serializable {



}