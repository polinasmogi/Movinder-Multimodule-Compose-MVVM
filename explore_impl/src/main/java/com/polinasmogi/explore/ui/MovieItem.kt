package com.polinasmogi.explore.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.polinasmogi.moviesapi.model.Doc

@Composable
fun MovieItem(movie: com.polinasmogi.moviesapi.model.Doc) {
    Box {
        AsyncImage(
            model = movie.poster?.url,
            contentDescription = "${movie.name} poster",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
    }
}