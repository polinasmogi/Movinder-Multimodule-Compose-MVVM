package com.polinasmogi.explore.di

import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.explore.interactor.ExploreInteractorImpl
import com.polinasmogi.explore.network.ExploreMoviesApi
import com.polinasmogi.explore.repository.ExploreMoviesRepository
import com.polinasmogi.explore.repository.ExploreMoviesRepositoryImpl
import com.polinasmogi.explore.viewmodel.ExploreViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
interface ExploreModule {

    @Binds
    @Singleton
    fun bindsRepository(repositoryImpl: ExploreMoviesRepositoryImpl): ExploreMoviesRepository

    @Binds
    @Singleton
    fun bindsInteractor(interactorImpl: ExploreInteractorImpl): ExploreInteractor

    @Binds
    fun bindsViewModelFactory(exploreViewModelFactory: ExploreViewModelFactory): ViewModelProvider.Factory

    companion object {

        const val IO = "IO"

        @Provides
        @Singleton
        @Named(IO)
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        fun provideApi(retrofit: Retrofit): ExploreMoviesApi {
            return retrofit.create(ExploreMoviesApi::class.java)
        }
    }
}
