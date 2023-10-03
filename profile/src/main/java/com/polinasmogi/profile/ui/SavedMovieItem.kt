package com.polinasmogi.profile.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.moviesapi.SampleData
import com.polinasmogi.moviesapi.model.LikedMovieModel
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun SavedMovieItem(
    movie: LikedMovieModel,
    onMovieClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onMovieClick.invoke(movie.id) }
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp)
                .height(100.dp)
        ) {
            movie.apply {
                AsyncImage(
                    model = movie.posterUrl,
                    contentDescription = "${movie.name} logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(70.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = genresString.orEmpty(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesExplorerPreview() {
    MovinderTheme {
        SavedMovieItem(SampleData.movieAModel, {})
    }
}