package com.polinasmogi.profile.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.profile.viewmodel.ProfileUiState
import com.polinasmogi.profile.viewmodel.ProfileViewModel
import com.polinasmogi.uikit.loader.LoaderComposable

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onMovieClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ProfileUiState.Loading -> {
            LoaderComposable()
        }
        is ProfileUiState.MovieList -> {
            MovieList(
                (uiState as ProfileUiState.MovieList).movies,
                onMovieClick
            )
        }
        is ProfileUiState.Error -> {
            val state = uiState as ProfileUiState.Error
            Text(
                modifier = Modifier.fillMaxSize(),
                text = state.errorMessage
            )
        }
        is ProfileUiState.NoMovies -> {
            EmptyList()
        }
    }
}
