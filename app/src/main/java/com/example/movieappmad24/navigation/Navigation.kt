package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen

@Composable
fun Navigation() {
    val navController = rememberNavController() // create a NavController instance

    val viewModel: MoviesViewModel = viewModel()
    NavHost(navController = navController, // pass the NavController to NavHost
        startDestination = Screen.Home.route) { // pass a start destination
        composable(route = Screen.Home.route){
            HomeScreen(navController, viewModel)
        }
        composable(route = Screen.Detail.route + "/{movieId}",
                arguments = listOf(
                    navArgument(name = "movieId") {type = NavType.StringType})
        ){ backStackEntry ->
            DetailScreen(viewModel.movieList.findLast { it.id == backStackEntry.arguments?.getString("movieId") },
                navController,
                viewModel)
        }
        composable(route = Screen.Watchlist.route) {
            WatchlistScreen(navController, viewModel)
        }
    }
}