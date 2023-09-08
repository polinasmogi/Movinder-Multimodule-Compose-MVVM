package com.polinasmogi.movie_info_impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.movie_info_impl.interactor.MovieInfoInteractor
import com.polinasmogi.moviesapi.SampleData
import com.polinasmogi.moviesapi.model.MovieModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.IndexOutOfBoundsException
import javax.inject.Inject

class MovieInfoViewModel
@Inject constructor(
    private val interactor: MovieInfoInteractor,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val viewModelState = MutableStateFlow(MovieInfoViewModelState(loading = true))

    val uiState = viewModelState
        .map(MovieInfoViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getMovieById(movieId: Int?) {
//        viewModelState.update {
//            it.copy(
//                loading = false,
//                movie = SampleData.movieDetails
//            )
//        }
        movieId?.let { id ->
            viewModelScope.launch(ioDispatcher) {
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

    fun onYesClicked(movie: MovieModel, movieIndex: Int) {
        viewModelScope.launch(ioDispatcher) {
            interactor.onMovieLiked(movie)
            viewModelState.update {
                it.copy(
//                    movie = movies[movieIndex + 1],
//                    movieIndex = movieIndex + 1,
//                    selectedMovie = null
                )
            }
        }
    }

    fun onNoClicked(movieIndex: Int) {
        try {
            viewModelState.update {
                it.copy(
//                    movie = movies[movieIndex + 1],
//                    movieIndex = movieIndex + 1,
//                    selectedMovie = null
                )
            }
        } catch (e: IndexOutOfBoundsException) {
            viewModelScope.launch(ioDispatcher) {
//                getMovies()
            }
        }
    }

    fun onBackPressed() {
        viewModelState.update {
            it.copy(
//                selectedMovie = null
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