package com.polinasmogi.movie_info_impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.movie_info_impl.di.MovieInfoModule.Companion.IO
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class MovieInfoViewModelFactory
    @Inject constructor(
        private val interactor: MovieInfoInteractor,
        @Named(IO) private val ioDispatcher: CoroutineDispatcher
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieInfoViewModel(interactor, ioDispatcher) as T
    }
}