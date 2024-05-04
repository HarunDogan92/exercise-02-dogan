package com.example.movieappmad24.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieappmad24.repos.MovieRepository

class DetailViewModelFactory(private val repository: MovieRepository, private val movieId: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(repository = repository, movieId = movieId) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}