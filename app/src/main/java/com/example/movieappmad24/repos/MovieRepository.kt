package com.example.movieappmad24.repos

import androidx.room.Query
import com.example.movieappmad24.data.MovieDao
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MovieWithImages
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {

    suspend fun add(movie: Movie) = movieDao.add(movie)
    suspend fun update(movie: Movie) = movieDao.update(movie)
    suspend fun delete(movie: Movie) = movieDao.delete(movie)
    fun fetchById(movieId: String): Flow<MovieWithImages> = movieDao.fetchById(movieId)
    fun fetchAll(): Flow<List<Movie>> = movieDao.fetchAll()
    fun fetchAllWithImages(): Flow<List<MovieWithImages>> = movieDao.fetchAllWithImages()
    fun fetchAllFavorites(): Flow<List<MovieWithImages>> = movieDao.fetchAllFavorites()
}