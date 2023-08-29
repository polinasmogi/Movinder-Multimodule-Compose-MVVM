package com.polinasmogi.explore.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.explore.viewmodel.ExploreUiState
import com.polinasmogi.explore.viewmodel.ExploreViewModel
import com.polinasmogi.moviesapi.ui.MovieInfoMediator

@Composable
fun ExploreScreen(
    viewModel: ExploreViewModel,
    mediator: MovieInfoMediator
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ExploreUiState.Loading -> {
//            Loading()
        }
        is ExploreUiState.MovieInfo -> {
            val state = uiState as ExploreUiState.MovieInfo
            mediator.ShowMovieInfo(movie = state.movie)
            BackHandler {
                viewModel.onBackPressed()
            }
        }
        is ExploreUiState.MovieCard -> {
            val state = uiState as ExploreUiState.MovieCard
            MoviesExplorer(
                movie = state.movie,
                onYesClick = { viewModel.onYesClicked(state.movie, state.movieIndex) },
                onNoCLick = { viewModel.onNoClicked(state.movieIndex) },
                onMovieClick = { viewModel.onMovieClick(state.movie) }
            )
        }
        is ExploreUiState.NoMovies -> {
            //show empty list
        }
        is ExploreUiState.Error -> { }
    }
}
