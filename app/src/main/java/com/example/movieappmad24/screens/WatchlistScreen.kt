package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.movieappmad24.data.MovieDatabase
import com.example.movieappmad24.models.WatchlistViewModel
import com.example.movieappmad24.models.WatchlistViewModelFactory
import com.example.movieappmad24.repos.MovieRepository
import com.example.movieappmad24.widgets.SimpleBottomAppBar
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun WatchlistScreen(navController: NavHostController) {
    val db = MovieDatabase.getDatabase(LocalContext.current, rememberCoroutineScope())
    val repo = MovieRepository(movieDao = db.movieDao())
    val factory = WatchlistViewModelFactory(repo)
    val viewModel: WatchlistViewModel = viewModel(factory = factory)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SimpleTopAppBar(title = "Your Watchlist") },
        bottomBar = { SimpleBottomAppBar(navController) }
    ) {
            values -> MovieList(movies = viewModel.movieList.collectAsState().value,
                values = values,
                navController = navController,
                onFavoriteClick = { movie -> viewModel.toggleFavoriteMovie(movie) })
    }
}