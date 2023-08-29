package com.polinasmogi.moviesapi.repository

import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.moviesapi.model.MoviesResponse

interface MoviesRepository {

    suspend fun getMovies(page: String) : MoviesResponse

    suspend fun onMovieLiked(movie: Doc)

    suspend fun getLikedMovies(): List<String?>
}
