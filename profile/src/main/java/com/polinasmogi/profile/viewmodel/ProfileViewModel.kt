package com.polinasmogi.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.profile.interactor.ProfileInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileViewModel
@Inject constructor(
    private val interactor: ProfileInteractor,
    private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    private val viewModelState = MutableStateFlow(ProfileViewModelState(loading = true))

    val uiState = viewModelState
        .map(ProfileViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        getSavedMovies()
    }

    private fun getSavedMovies() {
        viewModelScope.launch(ioDispatcher) {
            val movies = withContext(ioDispatcher) {
                interactor.getSavedMovies()
            }
            if (movies.isNotEmpty()) {
                viewModelState.update {
                    it.copy(
                        loading = false,
                        movies = movies
                    )
                }
            } else {
                viewModelState.update {
                    it.copy(
                        loading = false
                    )
                }
            }
        }
    }
}
