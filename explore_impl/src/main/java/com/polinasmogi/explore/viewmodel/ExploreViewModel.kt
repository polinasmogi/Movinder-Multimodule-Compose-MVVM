package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.moviesapi.ui.MovieInfoMediator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
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
    private val interactor: ExploreInteractor,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val viewModelState = MutableStateFlow(ExploreViewModelState(loading = true))

    val uiState = viewModelState
        .map(ExploreViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    private val movies = mutableListOf<com.polinasmogi.moviesapi.model.Doc>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch(ioDispatcher) {
            val movies = withContext(ioDispatcher) {
                interactor.getMovies().docs.filter { it.countries.size == 1 }
            }
            this@ExploreViewModel.movies.addAll(movies)
            viewModelState.update {
                it.copy(
                    loading = false,
                    movie = movies.first(),
                    movieIndex = 0
                )
            }
        }
    }

    fun onYesClicked(movie: Doc, movieIndex: Int) {
        viewModelScope.launch(ioDispatcher) {
            interactor.onMovieLiked(movie)
            viewModelState.update {
                it.copy(
                    movie = movies[movieIndex + 1],
                    movieIndex = movieIndex + 1,
                    selectedMovie = null
                )
            }
        }
    }

    fun onNoClicked(movieIndex: Int) {
        viewModelState.update {
            it.copy(
                movie = movies[movieIndex + 1],
                movieIndex = movieIndex + 1,
                selectedMovie = null
            )
        }
    }

    fun onMovieClick(movie: Doc) {
        viewModelState.update {
            it.copy(
                selectedMovie = movie
            )
        }
    }

    fun onBackPressed() {
        viewModelState.update {
            it.copy(
                selectedMovie = null
            )
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