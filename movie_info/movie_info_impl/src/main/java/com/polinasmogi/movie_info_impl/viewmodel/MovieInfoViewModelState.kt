package com.polinasmogi.movie_info_impl.viewmodel

data class MovieInfoViewModelState(
    val loading: Boolean = false,
    val movie: com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse? = null,
    val errorMessage: String = ""
) {

    fun toUiState(): MovieInfoUiState =
        when {
            loading -> MovieInfoUiState.Loading
            movie != null -> MovieInfoUiState.MovieInfo(movie = movie)
            else -> MovieInfoUiState.Error(errorMessage = errorMessage)
        }
}
