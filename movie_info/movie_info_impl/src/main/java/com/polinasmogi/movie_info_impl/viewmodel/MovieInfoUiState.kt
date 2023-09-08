package com.polinasmogi.movie_info_impl.viewmodel

import com.polinasmogi.moviesapi.model.info.MovieInfoResponse

sealed interface MovieInfoUiState {

    object Loading : MovieInfoUiState

    data class MovieInfo(
        val movie: MovieInfoResponse
    ) : MovieInfoUiState

    data class Error(
        val errorMessage: String
    ) : MovieInfoUiState
}
