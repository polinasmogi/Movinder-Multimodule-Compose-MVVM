package com.polinasmogi.movies.repository

import com.polinasmogi.database_api.database.LikedMoviesDao
import com.polinasmogi.movies.mappers.toLikedMovieEntity
import com.polinasmogi.movies.mappers.toMovieModels
import com.polinasmogi.moviesapi.model.LikedMovieModel
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import javax.inject.Inject

class BaseMoviesRepositoryImpl
    @Inject constructor(
        private val moviesDao: LikedMoviesDao
    ) : BaseMoviesRepository {

    override suspend fun onMovieLiked(movie: LikedMovieModel) {
        moviesDao.insertMovie(movie.toLikedMovieEntity())
    }

    override suspend fun getLikedMovies(): List<LikedMovieModel> {
        return moviesDao.getLikedMovies().toMovieModels()
    }
}
