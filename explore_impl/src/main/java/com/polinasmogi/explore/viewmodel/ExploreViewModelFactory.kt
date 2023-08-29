package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.explore.di.ExploreModule
import com.polinasmogi.explore.interactor.ExploreInteractor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class ExploreViewModelFactory
    @Inject constructor(
        private val interactor: ExploreInteractor,
        @Named(ExploreModule.IO) private val ioDispatcher: CoroutineDispatcher
    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExploreViewModel(interactor, ioDispatcher) as T
    }
}