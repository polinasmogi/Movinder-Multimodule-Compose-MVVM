package com.polinasmogi.moviesapi.repository

import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.model.info.MovieInfoResponse
import com.polinasmogi.moviesapi.network.model.model.MoviesResponse

interface MoviesRepository {

    suspend fun getMovies(page: String) : MoviesResponse

    suspend fun getMovieById(movieId: Int) : MovieInfoResponse

    suspend fun onMovieLiked(movie: MovieModel)

    suspend fun getLikedMovies(): List<MovieModel>
}
