package com.polinasmogi.movies.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.polinasmogi.moviesapi.model.Doc

@Composable
fun MovieInfo(
    movie: Doc
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = movie.poster?.url,
            contentDescription = "${movie.name} poster",
            contentScale = ContentScale.FillWidth
        )
        AsyncImage(
            model = movie.logo?.url,
            contentDescription = "${movie.name} logo",
            contentScale = ContentScale.FillWidth
        )
        movie.apply {
            name?.let { Text(text = it) }
            description?.let { Text(text = it) }
        }
    }
}
