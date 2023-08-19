package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.data.model.Doc

sealed interface ExploreUiState {

    object Loading : ExploreUiState

    data class NoMovies(
        val errorMessage: String
    ) : ExploreUiState

    data class MoviesList(
        val movies: List<Doc>
    ) : ExploreUiState

    data class MovieInfo(
        val movie: Doc
    ) : ExploreUiState
}
