package com.polinasmogi.explore.viewmodel

import com.polinasmogi.moviesapi.model.Doc

sealed interface ExploreUiState {

    object Loading : ExploreUiState

    data class NoMovies(
        val errorMessage: String
    ) : ExploreUiState

    data class MovieCard(
        val movie: Doc,
        val movieIndex: Int
    ) : ExploreUiState

    data class MovieInfo(
        val movie: Doc
    ) : ExploreUiState

    data class Error(
        val errorMessage: String
    ) : ExploreUiState
}
