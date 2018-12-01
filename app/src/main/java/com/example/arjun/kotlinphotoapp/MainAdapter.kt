package com.example.arjun.kotlinphotoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.arjun.kotlinphotoapp.models.Photo

class MainAdapter(var photos:List<Photo>,var  clicklistener:View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoViewHolder {

        return PhotoViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.photo_item,p0,false))

    }

    override fun getItemCount(): Int {
        return photos.size

    }

    override fun onBindViewHolder(p0: PhotoViewHolder, p1: Int) {

        val photo=photos[p1]
        p0?.tags?.text=photo.tags
        p0?.likes?.text=photo.likes.toString()
        p0?.favorites?.text=photo.favorites.toString()

        if(photo.previewURL.isNotEmpty()){
            Glide.with(p0?.tags?.context).load(photo.previewURL).into(p0?.photo_item)
        }

    }

    fun getPhoto(adapterposition:Int):Photo{
        return photos[adapterposition]

    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tags:TextView
        var likes:TextView
        var favorites:TextView
        var photo_item:ImageView

        init {
            if(clicklistener!=null){
                itemView.setOnClickListener(clicklistener)
            }

            itemView.tag=this
            tags=itemView.findViewById(R.id.tags) as TextView
            likes=itemView.findViewById(R.id.likes) as TextView
            favorites=itemView.findViewById(R.id.favorites) as TextView
            photo_item=itemView.findViewById(R.id.photo_item) as ImageView


        }



    }


}