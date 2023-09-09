package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.models.MovieToExploreModel

sealed interface ExploreUiState {

    object Loading : ExploreUiState

    data class NoMovies(
        val errorMessage: String
    ) : ExploreUiState

    data class MovieCard(
        val movie: MovieToExploreModel,
        val movieIndex: Int
    ) : ExploreUiState

    data class Error(
        val errorMessage: String?
    ) : ExploreUiState
}
