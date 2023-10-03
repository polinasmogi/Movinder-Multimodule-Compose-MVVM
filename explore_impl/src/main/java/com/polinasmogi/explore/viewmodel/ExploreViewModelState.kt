package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.models.MovieToExploreModel

data class ExploreViewModelState(
    val loading: Boolean = false,
    val movieIndex: Int? = null,
    val movie: MovieToExploreModel? = null,
    val errorMessage: String? = null
) {

    fun toUiState(): ExploreUiState =
        when {
            loading -> ExploreUiState.Loading
            movie != null && movieIndex != null -> ExploreUiState.MovieCard(movie = movie, movieIndex = movieIndex)
            errorMessage != null -> ExploreUiState.Error(errorMessage = errorMessage)
            else -> ExploreUiState.NoMovies
        }
}
