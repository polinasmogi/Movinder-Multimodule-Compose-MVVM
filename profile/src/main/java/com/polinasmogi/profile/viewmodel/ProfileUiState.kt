package com.polinasmogi.profile.viewmodel

import com.polinasmogi.moviesapi.model.MovieModel

sealed interface ProfileUiState {

    object Loading : ProfileUiState

    data class NoMovies(
        val errorMessage: String
    ) : ProfileUiState

    data class MovieList(
        val movies: List<MovieModel>
    ) : ProfileUiState

    data class Error(
        val errorMessage: String
    ) : ProfileUiState
}
