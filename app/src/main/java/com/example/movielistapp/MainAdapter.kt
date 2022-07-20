package com.example.movielistapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielistapp.data.Model
import com.example.movielistapp.databinding.AdapterMovieBinding

class MainAdapter(): RecyclerView.Adapter<MainViewHolder>() {

    private var movies = mutableListOf<Model>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movies: List<Model>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name
        holder.binding.category.text = movie.category
        holder.binding.description.text = movie.desc
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)

        holder.binding.expandedView.visibility = if (movie.expand) View.VISIBLE else View.GONE
        holder.binding.cardLayout.setOnClickListener {
            movie.expand = !movie.expand
            notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {}