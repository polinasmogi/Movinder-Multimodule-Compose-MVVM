package com.polinasmogi.profile.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.profile.viewmodel.ProfileUiState
import com.polinasmogi.profile.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ProfileUiState.Loading -> {
//            Loading()
        }
        is ProfileUiState.MovieList -> {
            MovieList((uiState as ProfileUiState.MovieList).movies)
        }
        is ProfileUiState.Error -> {}
        is ProfileUiState.NoMovies -> {}
    }
}
