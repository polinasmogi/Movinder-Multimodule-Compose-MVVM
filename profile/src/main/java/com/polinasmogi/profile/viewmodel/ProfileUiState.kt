package com.polinasmogi.profile.viewmodel

sealed interface ProfileUiState {

    object Loading : ProfileUiState

    data class NoMovies(
        val errorMessage: String
    ) : ProfileUiState

    data class MovieList(
        val movies: List<String?>
    ) : ProfileUiState

    data class Error(
        val errorMessage: String
    ) : ProfileUiState
}
