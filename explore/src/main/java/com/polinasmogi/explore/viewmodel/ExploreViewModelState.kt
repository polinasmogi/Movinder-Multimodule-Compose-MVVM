package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.data.model.Doc

data class ExploreViewModelState(
    val loading: Boolean = false,
    val movies: List<Doc>? = null,
    val selectedMovie: Doc? = null,
    val errorMessage: String = ""
) {

    fun toUiState(): ExploreUiState =
        when {
            loading -> ExploreUiState.Loading
            selectedMovie != null -> ExploreUiState.MovieInfo(movie = selectedMovie)
            movies.isNullOrEmpty() -> ExploreUiState.NoMovies(errorMessage = errorMessage)
            else -> ExploreUiState.MoviesList(movies = movies)
        }
}
