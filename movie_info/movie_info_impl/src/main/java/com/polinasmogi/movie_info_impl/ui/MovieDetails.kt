package com.polinasmogi.movie_info_impl.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun MovieDetails(movieInfo: MovieInfoResponse) {
    movieInfo.apply {
        AsyncImage(
            model = poster?.url,
            contentDescription = "$name poster",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
                .height(300.dp)
        )
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 230.dp, bottom = 80.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        ),
                        endY = 250F
                    )
                )
        ) {
            Text(
                text = name.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = "$year, ${genres.first().name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
            var isExpanded = false
            Text(
                text = description.toString(),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp),
//                    .clickable {
//                        isExpanded = !isExpanded
//                    },
//                maxLines = if (isExpanded) Int.MAX_VALUE else 4,
//                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                items(movieInfo.persons) {
                    PersonItem(it)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MovieDetailsPreview() {
    MovinderTheme {
//        MovieDetails(SampleData.movieDetails)
    }
}
