package com.polinasmogi.movie_info_impl.di

import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractor
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractorImpl
import com.polinasmogi.movie_info_impl.network.MovieInfoApi
import com.polinasmogi.movie_info_impl.repository.MovieInfoRepository
import com.polinasmogi.movie_info_impl.repository.MovieInfoRepositoryImpl
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
interface MovieInfoModule {

    @Binds
    @Singleton
    fun bindsRepository(repositoryImpl: MovieInfoRepositoryImpl): MovieInfoRepository

    @Binds
    @Singleton
    fun bindsInteractor(interactorImpl: MovieInfoInteractorImpl): MovieInfoInteractor

    @Binds
    fun bindsViewModelFactory(viewModelFactory: MovieInfoViewModelFactory): ViewModelProvider.Factory

    companion object {

        const val IO = "IO"

        @Provides
        @Singleton
        @Named(IO)
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        fun provideApi(retrofit: Retrofit): MovieInfoApi {
            return retrofit.create(MovieInfoApi::class.java)
        }
    }
}
