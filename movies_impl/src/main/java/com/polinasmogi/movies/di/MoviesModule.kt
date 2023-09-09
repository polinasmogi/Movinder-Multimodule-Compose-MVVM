package com.polinasmogi.movies.di

import com.polinasmogi.movies.repository.BaseMoviesRepositoryImpl
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface MoviesModule {

    @Binds
    @Singleton
    fun bindsMoviesRepository(moviesRepositoryImpl: BaseMoviesRepositoryImpl): BaseMoviesRepository
}