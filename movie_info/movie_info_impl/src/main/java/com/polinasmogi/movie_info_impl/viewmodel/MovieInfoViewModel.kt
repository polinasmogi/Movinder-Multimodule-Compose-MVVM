package com.polinasmogi.movie_info_impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractor
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieInfoViewModel
@Inject constructor(
    private val interactor: MovieInfoInteractor,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, t ->
        viewModelState.update {
            it.copy(
                loading = false,
                errorMessage = t.localizedMessage
            )
        }
    }
    private val scope = CoroutineScope(ioDispatcher + handler)

    private val viewModelState = MutableStateFlow(MovieInfoViewModelState(loading = true))

    val uiState = viewModelState
        .map(MovieInfoViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getMovieById(movieId: Int?) {
        movieId?.let { id ->
            scope.launch {
                val movie = withContext(ioDispatcher) {
                    interactor.getMovieById(id)
                }
                viewModelState.update {
                    it.copy(
                        loading = false,
                        movie = movie
                    )
                }
            }
        }
    }

    fun onYesClicked(movie: MovieInfoResponse) {
        scope.launch() {
            interactor.onMovieLiked(movie)
        }
    }
}