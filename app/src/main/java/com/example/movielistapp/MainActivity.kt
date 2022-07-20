package com.example.movielistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movielistapp.data.MainRepository
import com.example.movielistapp.data.Model
import com.example.movielistapp.data.RetrofitService
import com.example.movielistapp.databinding.ActivityMainBinding
import com.example.movielistapp.factory.MainViewModelFactory
import com.example.movielistapp.viewmodels.MainViewModel

//Steps:
// add dependencies
// setup data layer -- model class and retrofit
// setup repository
// setup view model -- live data - view model factory
// set up UI

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this) {
            Log.d(tag, "onCreate: $it")
            adapter.setMovieList(it)
        }
        viewModel.errorMessage.observe(this) {
        }
        viewModel.getAllMovies()
    }

}
