package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.explore.models.MovieToExploreModel
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

class ExploreViewModel
@Inject constructor(
    private val interactor: ExploreInteractor,
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

    private val viewModelState = MutableStateFlow(ExploreViewModelState(loading = true))

    val uiState = viewModelState
        .map(ExploreViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    private val movies = mutableListOf<MovieToExploreModel>()

    init {
        getMovies()
    }

    private fun getMovies(page: Int? = null) {
        scope.launch {
            val moviesToExplore = withContext(ioDispatcher) {
                interactor.getMoviesToExplore(page)
            }
            this@ExploreViewModel.movies.addAll(moviesToExplore)
            viewModelState.update {
                it.copy(
                    loading = false,
                    movie = movies.first(),
                    movieIndex = 0
                )
            }
        }
    }

    fun onYesClicked(movie: MovieToExploreModel, movieIndex: Int) {
        viewModelScope.launch(ioDispatcher) {
            interactor.onMovieLiked(movie)
            showNextMovie(movieIndex, movie.page)
        }
    }

    fun onNoClicked(movieId: Int, movieIndex: Int, page: Int) {
        viewModelScope.launch(ioDispatcher) {
            interactor.onMovieDisliked(movieId)
            showNextMovie(movieIndex, page)
        }
    }

    private fun showNextMovie(movieIndex: Int, page: Int) {
        try {
            viewModelState.update {
                it.copy(
                    movie = movies[movieIndex + 1],
                    movieIndex = movieIndex + 1
                )
            }
            movies.removeAt(movieIndex)
        } catch (e: IndexOutOfBoundsException) {
            getMovies(page)
        }
    }
}