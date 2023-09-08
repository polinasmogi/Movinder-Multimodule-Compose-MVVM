package com.polinasmogi.explore.viewmodel

import com.polinasmogi.moviesapi.model.MovieModel

data class ExploreViewModelState(
    val loading: Boolean = false,
    val movieIndex: Int? = null,
    val movie: MovieModel? = null,
    val selectedMovie: MovieModel? = null,
    val errorMessage: String? = ""
) {

    fun toUiState(): ExploreUiState =
        when {
            loading -> ExploreUiState.Loading
            selectedMovie != null -> ExploreUiState.MovieInfo(movie = selectedMovie)
            movie != null && movieIndex != null -> ExploreUiState.MovieCard(movie = movie, movieIndex = movieIndex)
            else -> ExploreUiState.Error(errorMessage = errorMessage)
        }
}
