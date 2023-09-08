package com.polinasmogi.explore.viewmodel

import com.polinasmogi.moviesapi.model.MovieModel

sealed interface ExploreUiState {

    object Loading : ExploreUiState

    data class NoMovies(
        val errorMessage: String
    ) : ExploreUiState

    data class MovieCard(
        val movie: MovieModel,
        val movieIndex: Int
    ) : ExploreUiState

    data class MovieInfo(
        val movie: MovieModel
    ) : ExploreUiState

    data class Error(
        val errorMessage: String?
    ) : ExploreUiState
}
