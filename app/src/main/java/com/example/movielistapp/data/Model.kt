package com.example.movielistapp.data

data class Model (
    val name: String,
    val imageUrl: String,
    val category: String,
    val desc: String,
    var expand : Boolean = false
)