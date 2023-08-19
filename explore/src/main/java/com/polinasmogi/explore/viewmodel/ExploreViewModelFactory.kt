package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.explore.data.network.MoviesApi
import com.polinasmogi.explore.data.repository.MoviesRepository
import com.polinasmogi.explore.interactor.MoviesInteractor
import javax.inject.Inject

class ExploreViewModelFactory
    @Inject constructor(private val interactor: MoviesInteractor) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExploreViewModel(interactor) as T
    }
}