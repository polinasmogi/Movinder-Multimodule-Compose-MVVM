package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.explore.models.MovieToExploreModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
            scope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    private val movies = mutableListOf<MovieToExploreModel>()
    fun getMoviesForTest() : List<MovieToExploreModel> = movies

    init {
        getMovies()
    }

    private fun getMovies(page: Int? = null) {
        scope.launch {
            val moviesToExplore = async { interactor.getMoviesToExplore(page) }.await()
            if (moviesToExplore.isEmpty()) {
                viewModelState.update {
                    it.copy(
                        loading = false
                    )
                }
            } else {
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
    }

    fun onYesClicked(movie: MovieToExploreModel, movieIndex: Int) {
        scope.launch {
            interactor.onMovieLiked(movie)
            showNextMovie(movieIndex, movie.page)
        }
    }

    fun onNoClicked(movieId: Int, movieIndex: Int, page: Int) {
        scope.launch {
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