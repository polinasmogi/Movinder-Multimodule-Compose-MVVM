package com.polinasmogi.explore.data.repository

import com.polinasmogi.explore.data.model.MoviesResponse

interface MoviesRepository {

    suspend fun getMovies(page: String) : MoviesResponse
}
