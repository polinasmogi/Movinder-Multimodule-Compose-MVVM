package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.data.model.MoviesResponse

interface MoviesInteractor {

    suspend fun getMovies(): MoviesResponse
}