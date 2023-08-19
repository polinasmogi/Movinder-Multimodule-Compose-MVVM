package com.polinasmogi.explore.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.explore.data.model.Doc
import com.polinasmogi.explore.viewmodel.ExploreUiState
import com.polinasmogi.explore.viewmodel.ExploreViewModel

@Composable
fun ExploreScreen(
    viewModel: ExploreViewModel
) {

    viewModel.getMovies()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        ExploreUiState.Loading -> {
//            Loading()
        }
        is ExploreUiState.MovieInfo -> {
            //show movie info
        }
        is ExploreUiState.MoviesList -> {
            MoviesList(movies = (uiState as ExploreUiState.MoviesList).movies)
        }
        is ExploreUiState.NoMovies -> {
            //show empty list
        }
    }
}

@Composable
fun MoviesList(
    movies: List<Doc>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(movies) {
                it.name?.let { it1 -> Text(text = it1) }
            }
        }
    }
}