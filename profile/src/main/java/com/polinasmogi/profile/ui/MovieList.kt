package com.polinasmogi.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.polinasmogi.moviesapi.model.LikedMovieModel
import com.polinasmogi.strings.R

@Composable
fun MovieList(
    movies: List<LikedMovieModel>,
    onMovieClick: (Int) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 56.dp, top = 24.dp)
        .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.movie_list_title),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(movies) {
                SavedMovieItem(it, onMovieClick)
            }
        }
    }
}
