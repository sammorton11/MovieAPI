package com.example.movielistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movielistapp.data.MainRepository
import com.example.movielistapp.data.Model
import com.example.movielistapp.data.RetrofitService
import com.example.movielistapp.databinding.ActivityMainBinding
import com.example.movielistapp.factory.MainViewModelFactory
import com.example.movielistapp.viewmodels.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

//Steps:
// add dependencies
// setup data layer -- model class and retrofit
// setup repository
// setup view model -- live data - view model factory
// set up UI

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {

    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter(this)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this) {
            Log.d(tag, "onCreate: $it")
            adapter.setMovieList(it)
        }
        viewModel.errorMessage.observe(this) {
        }
        viewModel.getAllMovies()



    }

    override fun itemClicked(expanded: Boolean, position: Int) {
        if (expanded){
           binding.recyclerview.layoutManager?.scrollToPosition(position)
        }
    }

}
