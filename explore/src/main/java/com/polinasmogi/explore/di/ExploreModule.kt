package com.polinasmogi.explore.di

import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.core_api.network.NetworkProvider
import com.polinasmogi.explore.data.network.MoviesApi
import com.polinasmogi.explore.data.repository.MoviesRepository
import com.polinasmogi.explore.data.repository.MoviesRepositoryImpl
import com.polinasmogi.explore.interactor.MoviesInteractor
import com.polinasmogi.explore.interactor.MoviesInteractorImpl
import com.polinasmogi.explore.viewmodel.ExploreViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface ExploreModule {

    @Binds
    @Singleton
    fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    @Singleton
    fun bindsMoviesInteractor(moviesInteractorImpl: MoviesInteractorImpl): MoviesInteractor

    @Binds
    fun bindsHomeViewModelFactory(exploreViewModelFactory: ExploreViewModelFactory): ViewModelProvider.Factory

    companion object {

        @Provides
        fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
            return retrofit.create(MoviesApi::class.java)
        }
    }
}
