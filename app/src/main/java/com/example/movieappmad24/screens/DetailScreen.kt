package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieRow
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.widgets.SimpleTopAppBar

@Composable
fun DetailScreen(movie: Movie?, navController: NavHostController, viewModel: MoviesViewModel) {
    if (movie != null) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { SimpleTopAppBar(movie.title, navController) }
        ) {
            values ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(values)) {
                    MovieRow(movie, onFavoriteClick = { movieId -> viewModel.toggleFavoriteMovie(movieId) })
                    MovieImages(movie)
                }
        }
    } else {
        Text("Movie not found")
    }
}

@Composable
fun MovieImages(movie: Movie) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(movie.images) { image ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = ShapeDefaults.Large,
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentScale = ContentScale.Fit,
                    contentDescription = "movie images"
                )
            }
        }
    }
}