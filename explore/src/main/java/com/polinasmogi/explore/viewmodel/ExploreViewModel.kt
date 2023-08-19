package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.explore.data.network.MoviesApi
import com.polinasmogi.explore.interactor.MoviesInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExploreViewModel
@Inject constructor(
    private val interactor: MoviesInteractor
) : ViewModel() {

    private val viewModelState = MutableStateFlow(ExploreViewModelState(loading = true))

    val uiState = viewModelState
        .map(ExploreViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getMovies() {
        viewModelScope.launch(handler) {
            val movies = withContext(Dispatchers.Default) {
                interactor.getMovies()
            }
            viewModelState.update {
                it.copy(
                    loading = false,
                    movies = movies.docs
                )
            }
        }
    }

    private val handler = CoroutineExceptionHandler { _, _ ->
        viewModelState.update {
            it.copy(
                loading = false,
                errorMessage = "Errorr oror oor"
            )
        }
    }
}