package com.example.movieappmad24.models

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class MoviesViewModel : ViewModel() {
    private val _movieList = getMovies().toMutableStateList()

    val movieList: List<Movie>
        get() = _movieList

    val favoriteMovies : List<Movie>
        get() = _movieList.filter { movie -> movie.isFavorite }

    fun toggleFavoriteMovie(movieId: String) =
        _movieList.find { it.id == movieId }?.let { movie -> movie.isFavorite = !movie.isFavorite }
}