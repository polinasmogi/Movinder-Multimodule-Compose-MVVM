package com.polinasmogi.moviesapi

import com.polinasmogi.moviesapi.repository.BaseMoviesRepository

interface MoviesProvider {

    fun provideMoviesRepository(): BaseMoviesRepository
}