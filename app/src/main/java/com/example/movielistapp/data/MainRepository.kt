package com.example.movielistapp.data

class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}