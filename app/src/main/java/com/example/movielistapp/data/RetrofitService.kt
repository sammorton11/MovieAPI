package com.example.movielistapp.data

import android.graphics.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("movielist.json")
    fun getAllMovies(): Call<List<Model>>

    companion object {
        var retrofitService: RetrofitService? = null

    }
}