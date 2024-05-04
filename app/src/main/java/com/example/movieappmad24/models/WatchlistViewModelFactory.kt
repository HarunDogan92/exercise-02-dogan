package com.example.movieappmad24.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad24.repos.MovieRepository

class WatchlistViewModelFactory(private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WatchlistViewModel::class.java))
            return WatchlistViewModel(repository = repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}