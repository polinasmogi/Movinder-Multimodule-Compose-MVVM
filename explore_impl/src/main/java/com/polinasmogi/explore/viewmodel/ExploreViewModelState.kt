package com.polinasmogi.explore.viewmodel

import com.polinasmogi.moviesapi.model.Doc

data class ExploreViewModelState(
    val loading: Boolean = false,
    val movieIndex: Int? = null,
    val movie: Doc? = null,
    val selectedMovie: Doc? = null,
    val errorMessage: String = ""
) {

    fun toUiState(): ExploreUiState =
        when {
            loading -> ExploreUiState.Loading
            selectedMovie != null -> ExploreUiState.MovieInfo(movie = selectedMovie)
            movie != null && movieIndex != null -> ExploreUiState.MovieCard(movie = movie, movieIndex = movieIndex)
            else -> ExploreUiState.Error(errorMessage = errorMessage)
        }
}
