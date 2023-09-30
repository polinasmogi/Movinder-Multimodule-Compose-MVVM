package com.polinasmogi.explore.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.explore.viewmodel.ExploreUiState
import com.polinasmogi.explore.viewmodel.ExploreViewModel
import com.polinasmogi.uikit.loader.LoaderComposable

@Composable
fun ExploreScreen(
    viewModel: ExploreViewModel,
    onMovieClick: (Int) -> Unit
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ExploreUiState.Loading -> {
            LoaderComposable()
        }
        is ExploreUiState.MovieCard -> {
            val state = uiState as ExploreUiState.MovieCard
            MoviesExplorer(
                movie = state.movie,
                onYesClick = { viewModel.onYesClicked(state.movie, state.movieIndex) },
                onNoCLick = { viewModel.onNoClicked(state.movie.id, state.movieIndex, state.movie.page) },
                showMoreAction = { onMovieClick.invoke(state.movie.id) }
            )
        }
        is ExploreUiState.NoMovies -> {
            //show empty list
        }
        is ExploreUiState.Error -> {
            val state = uiState as ExploreUiState.Error
            Text(
                modifier = Modifier.fillMaxSize(),
                text = state.errorMessage.orEmpty()
            )
        }
    }
}
