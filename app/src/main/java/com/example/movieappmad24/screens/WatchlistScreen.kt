package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.widgets.SimpleBottomAppBar
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun WatchlistScreen(navController: NavHostController, viewModel: MoviesViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SimpleTopAppBar(title = "Your Watchlist") },
        bottomBar = { SimpleBottomAppBar(navController) }
    ) {
            values -> MovieList(movies = viewModel.favoriteMovies,
                values = values,
                navController = navController,
                onFavoriteClick = { movieId -> viewModel.toggleFavoriteMovie(movieId) })
    }
}