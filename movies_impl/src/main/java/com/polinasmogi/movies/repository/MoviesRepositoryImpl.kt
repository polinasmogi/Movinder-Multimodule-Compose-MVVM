package com.polinasmogi.movies.repository

import com.polinasmogi.database_api.database.MoviesDao
import com.polinasmogi.movies.mappers.toLikedMovieEntity
import com.polinasmogi.movies.mappers.toMovieModels
import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.model.info.MovieInfoResponse
import com.polinasmogi.moviesapi.network.model.model.MoviesResponse
import com.polinasmogi.moviesapi.network.MoviesApi
import com.polinasmogi.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl
    @Inject constructor(
        private val moviesApi: MoviesApi,
        private val moviesDao: MoviesDao
    ) : MoviesRepository {

    override suspend fun getMovies(page: String): MoviesResponse =
        moviesApi.getMovies(page, country = "Корея Южная", type = "tv-series")

    override suspend fun getMovieById(movieId: Int): MovieInfoResponse =
        moviesApi.getMovieById(movieId)

    override suspend fun onMovieLiked(movie: MovieModel) {
        moviesDao.insertMovie(movie.toLikedMovieEntity())
    }

    override suspend fun getLikedMovies(): List<MovieModel> {
        return moviesDao.getLikedMovies().toMovieModels()
    }
}
