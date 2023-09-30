package com.polinasmogi.explore.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.ui_atoms.theme.MovinderTheme
import com.polinasmogi.uikit.buttons.NoButton
import com.polinasmogi.uikit.buttons.YesButton

@Composable
fun MoviesExplorer(
    movie: MovieToExploreModel,
    onYesClick: () -> Unit,
    onNoCLick: () -> Unit,
    showMoreAction: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
    ) {
        MovieItem(movie = movie, showMoreAction = showMoreAction)
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        ),
                        endY = 300F
                    )
                )
        ) {
            NoButton(
                action = onNoCLick,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 80.dp, bottom = 20.dp, top = 20.dp)
            )
            YesButton(
                action = onYesClick,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 80.dp, bottom = 20.dp, top = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesExplorerPreview() {
    MovinderTheme {
//        MoviesExplorer(SampleData.movieAModel, {}, {}, {})
    }
}