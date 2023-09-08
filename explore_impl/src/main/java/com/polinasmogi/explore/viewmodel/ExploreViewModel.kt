package com.polinasmogi.explore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.moviesapi.SampleData
import com.polinasmogi.moviesapi.model.MovieModel
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
import java.lang.IndexOutOfBoundsException
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

    private val movies = mutableListOf<MovieModel>()

    init {
        getMovies()
    }

    private fun getMovies() {
        scope.launch() {
//            this@ExploreViewModel.movies.addAll(listOf(SampleData.movieAModel, SampleData.movieAModel, SampleData.movieAModel))
//            viewModelState.update {
//                it.copy(
//                    loading = false,
//                    movie = movies.first(),
//                    movieIndex = 0
//                )
//            }
            val movies = withContext(ioDispatcher) {
                interactor.getMovies()
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

    fun onYesClicked(movie: MovieModel, movieIndex: Int) {
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
        try {
            viewModelState.update {
                it.copy(
                    movie = movies[movieIndex + 1],
                    movieIndex = movieIndex + 1,
                    selectedMovie = null
                )
            }
        } catch (e: IndexOutOfBoundsException) {
            viewModelScope.launch(ioDispatcher) {
                getMovies()
            }
        }
    }

    fun onMovieClick(movie: MovieModel) {
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
}