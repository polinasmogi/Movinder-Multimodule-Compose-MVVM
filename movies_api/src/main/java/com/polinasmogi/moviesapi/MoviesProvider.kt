package com.polinasmogi.moviesapi

import com.polinasmogi.moviesapi.repository.MoviesRepository

interface MoviesProvider {

    fun provideMoviesRepository(): MoviesRepository
}