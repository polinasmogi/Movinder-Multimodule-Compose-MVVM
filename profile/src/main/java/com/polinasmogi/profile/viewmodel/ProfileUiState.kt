package com.polinasmogi.profile.viewmodel

import com.polinasmogi.moviesapi.model.LikedMovieModel

sealed interface ProfileUiState {

    object Loading : ProfileUiState

    object NoMovies : ProfileUiState

    data class MovieList(
        val movies: List<LikedMovieModel>
    ) : ProfileUiState

    data class Error(
        val errorMessage: String
    ) : ProfileUiState
}
