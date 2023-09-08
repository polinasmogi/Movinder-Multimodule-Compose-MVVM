package com.polinasmogi.profile.viewmodel

import com.polinasmogi.moviesapi.model.MovieModel

data class ProfileViewModelState(
    val loading: Boolean = false,
    val movies: List<MovieModel>? = null,
    val errorMessage: String = ""
) {

    fun toUiState(): ProfileUiState =
        when {
            loading -> ProfileUiState.Loading
            movies != null -> ProfileUiState.MovieList(movies = movies)
            else -> ProfileUiState.Error(errorMessage = errorMessage)
        }
}
