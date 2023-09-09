package com.polinasmogi.moviesapi.repository

import com.polinasmogi.moviesapi.model.LikedMovieModel

interface BaseMoviesRepository {

    suspend fun onMovieLiked(movie: LikedMovieModel)

    suspend fun getLikedMovies(): List<LikedMovieModel>
}
