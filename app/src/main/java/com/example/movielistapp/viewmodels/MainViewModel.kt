package com.example.movielistapp.viewmodels

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielistapp.data.MainRepository
import com.example.movielistapp.data.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository): ViewModel() {

    val movieList = MutableLiveData<List<Model>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


    fun setUpDesc(description: TextView?, desc: String?){
        description?.text = desc
    }
}