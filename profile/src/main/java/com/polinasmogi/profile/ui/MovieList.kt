package com.polinasmogi.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.polinasmogi.moviesapi.model.MovieModel

@Composable
fun MovieList(movies: List<MovieModel>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(movies) {
                SavedMovieItem(it)
            }
        }
    }
}
