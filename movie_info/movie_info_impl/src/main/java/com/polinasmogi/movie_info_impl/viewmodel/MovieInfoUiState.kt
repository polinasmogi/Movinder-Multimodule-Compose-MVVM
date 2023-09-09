package com.polinasmogi.movie_info_impl.viewmodel

sealed interface MovieInfoUiState {

    object Loading : MovieInfoUiState

    data class MovieInfo(
        val movie: com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
    ) : MovieInfoUiState

    data class Error(
        val errorMessage: String
    ) : MovieInfoUiState
}
