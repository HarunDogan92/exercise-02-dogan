package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieRow
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.widgets.SimpleBottomAppBar
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun HomeScreen(navController: NavHostController, viewModel: MoviesViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { SimpleTopAppBar(title = "Movie App") },
        bottomBar = { SimpleBottomAppBar(navController) }
    ) {
            values -> MovieList(movies = viewModel.movieList, values = values,
                navController = navController,
                onFavoriteClick = { movieId -> viewModel.toggleFavoriteMovie(movieId) }
                )
    }
}

@Composable
fun MovieList(
    movies: List<Movie>,
    values: PaddingValues,
    navController: NavHostController,
    onFavoriteClick: (String) -> Unit = {},
    ) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(values)
    ) {
        items(movies) {
                movie -> MovieRow(
                    movie = movie,
                    onItemClick = {movieId -> navController.navigate(route = Screen.Detail.route + "/$movieId") },
                    onFavoriteClick = onFavoriteClick
                )
        }
    }
}