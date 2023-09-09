package com.polinasmogi.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.polinasmogi.moviesapi.model.LikedMovieModel

@Composable
fun MovieList(
    movies: List<LikedMovieModel>,
    onMovieClick: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()
        .padding(bottom = 80.dp)
    ) {
        LazyColumn {
            items(movies) {
                SavedMovieItem(it, onMovieClick)
            }
        }
    }
}
