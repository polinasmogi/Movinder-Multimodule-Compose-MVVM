package com.polinasmogi.movie_info_impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoUiState
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModel
import com.polinasmogi.uikit.loader.LoaderComposable

@Composable
fun MovieInfoScreen(
    viewModel: MovieInfoViewModel,
    movieId: Int?
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(movieId) {
        viewModel.getMovieById(movieId)
    }

    when (uiState) {
        is MovieInfoUiState.Error -> {}
        MovieInfoUiState.Loading -> {
            LoaderComposable()
        }
        is MovieInfoUiState.MovieInfo -> {
            MovieDetails((uiState as MovieInfoUiState.MovieInfo).movie)
        }
    }
}
