package com.polinasmogi.explore.data.repository

import com.polinasmogi.explore.data.model.MoviesResponse
import com.polinasmogi.explore.data.network.MoviesApi
import javax.inject.Inject

class MoviesRepositoryImpl
    @Inject constructor(private val moviesApi: MoviesApi) : MoviesRepository {

    override suspend fun getMovies(page: String): MoviesResponse =
        moviesApi.getMovies(page)
}
