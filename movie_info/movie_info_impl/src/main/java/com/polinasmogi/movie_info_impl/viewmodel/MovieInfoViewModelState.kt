package com.polinasmogi.movie_info_impl.viewmodel

import com.polinasmogi.moviesapi.model.info.MovieInfoResponse

data class MovieInfoViewModelState(
    val loading: Boolean = false,
    val movie: MovieInfoResponse? = null,
    val errorMessage: String = ""
) {

    fun toUiState(): MovieInfoUiState =
        when {
            loading -> MovieInfoUiState.Loading
            movie != null -> MovieInfoUiState.MovieInfo(movie = movie)
            else -> MovieInfoUiState.Error(errorMessage = errorMessage)
        }
}
