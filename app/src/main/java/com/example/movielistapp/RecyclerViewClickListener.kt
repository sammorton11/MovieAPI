package com.example.movielistapp

import android.view.View

interface ItemClickListener {
    fun itemClicked(expanded: Boolean, position: Int)
}