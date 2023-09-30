package com.polinasmogi.explore.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.strings.R

@Composable
fun MovieItem(
    movie: MovieToExploreModel,
    showMoreAction: () -> Unit
    ) {
    AsyncImage(
        model = movie.posterUrl,
        contentDescription = "${movie.name} logo",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0))
            .padding(top = 430.dp, bottom = 80.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colorScheme.background
                    ),
                    endY = 400F
                )
            )
    ) {
        movie.apply {
            Text(
                text = genresString.orEmpty(),
                modifier = Modifier
                    .padding(top = 90.dp)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleLarge,
            )
            shortDescription?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp)
                )
            }
            Text(
                text = stringResource(R.string.show_more_button),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .clickable {
                        showMoreAction.invoke()
                    }
            )
        }
    }
}
