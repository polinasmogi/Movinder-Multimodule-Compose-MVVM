package com.polinasmogi.moviesapi

import com.polinasmogi.moviesapi.repository.MoviesRepository
import com.polinasmogi.moviesapi.ui.MovieInfoMediator

interface MoviesProvider {

    fun provideMoviesRepository(): MoviesRepository

    fun provideMediator(): MovieInfoMediator
}