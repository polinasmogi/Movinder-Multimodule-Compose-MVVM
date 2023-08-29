package com.polinasmogi.explore.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polinasmogi.moviesapi.SampleData
import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun MoviesExplorer(
    movie: com.polinasmogi.moviesapi.model.Doc,
    onYesClick: () -> Unit,
    onNoCLick: () -> Unit,
    onMovieClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(bottom = 56.dp)
            .clickable {
                onMovieClick.invoke()
            }
    ) {
        MovieItem(movie = movie)
        Button(
            onClick = { onNoCLick.invoke() },
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(text = "no")
        }
        Button(
            onClick = { onYesClick.invoke() },
            modifier = Modifier.align(Alignment.BottomEnd),
        ) {
            Text(text = "yes")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesExplorerPreview() {
    MovinderTheme {
        MoviesExplorer(com.polinasmogi.moviesapi.SampleData.movieA, {}, {}, {})
    }
}