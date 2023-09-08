package com.polinasmogi.movie_info_impl.di

import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModelFactory
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractor
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
interface MovieInfoModule {

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
    }
}
