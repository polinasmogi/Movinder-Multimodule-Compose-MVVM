package com.polinasmogi.movies.di

import com.polinasmogi.movies.repository.MoviesRepositoryImpl
import com.polinasmogi.movies.ui.MovieInfoMediatorImpl
import com.polinasmogi.moviesapi.network.MoviesApi
import com.polinasmogi.moviesapi.repository.MoviesRepository
import com.polinasmogi.moviesapi.ui.MovieInfoMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface MoviesModule {

    @Binds
    @Singleton
    fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

//    @Binds
//    @Singleton
//    fun bindsMediator(mediator: MovieInfoMediatorImpl): MovieInfoMediator

    companion object {

        @Provides
        fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
            return retrofit.create(MoviesApi::class.java)
        }

        @Provides
        fun provideMediator(): MovieInfoMediator {
            return MovieInfoMediatorImpl()
        }
    }
}