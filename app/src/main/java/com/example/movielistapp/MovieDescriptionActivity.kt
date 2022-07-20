package com.example.movielistapp

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.movielistapp.data.MainRepository
import com.example.movielistapp.data.Model
import com.example.movielistapp.data.RetrofitService
import com.example.movielistapp.databinding.ActivityMainBinding
import com.example.movielistapp.databinding.ActivityMovieDescriptionBinding
import com.example.movielistapp.factory.MainViewModelFactory
import com.example.movielistapp.viewmodels.MainViewModel

class MovieDescriptionActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMovieDescriptionBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var  description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDescriptionBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_movie_description)

        val movies: List<Model> = mutableListOf<Model>()

//        description = binding.descriptionTextView

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)
    }

    private fun setupUI(){

        val movieDescription = intent.getStringExtra("desc")
        viewModel.setUpDesc(description, movieDescription)
    }
}