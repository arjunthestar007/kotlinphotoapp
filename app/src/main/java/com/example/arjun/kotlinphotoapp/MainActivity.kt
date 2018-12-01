package com.example.arjun.kotlinphotoapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.arjun.kotlinphotoapp.api.PhotoRetriever
import com.example.arjun.kotlinphotoapp.models.Photo
import com.example.arjun.kotlinphotoapp.models.PhotoList

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var photos:List<Photo>?=null;
    var mainadapter:MainAdapter?=null;
    lateinit var recyclerview:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerview=findViewById(R.id.review) as RecyclerView
        recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        var retriever=PhotoRetriever()
        val callback= object : Callback<PhotoList> {
            override fun onFailure(call: Call<PhotoList>, t: Throwable) {


            }


            override fun onResponse(call: Call<PhotoList>, response: Response<PhotoList>) {

                response.isSuccessful.let {
                    this@MainActivity.photos=response?.body()?.hits
                    mainadapter= MainAdapter(this@MainActivity.photos!!,this@MainActivity )
                    recyclerview.adapter=mainadapter
                }
            }

        }

        retriever.getphotos(callback);


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
