package com.example.movielistapp.data

import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}