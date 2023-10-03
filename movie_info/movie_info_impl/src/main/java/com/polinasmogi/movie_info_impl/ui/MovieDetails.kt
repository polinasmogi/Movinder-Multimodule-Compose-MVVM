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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.movie_info_impl.data.MovieInfoSampleData
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.strings.R
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun MovieDetails(
    movieInfo: MovieInfoResponse,
    action: () -> Unit
) {
    movieInfo.apply {
        AsyncImage(
            model = poster?.url,
            contentDescription = stringResource(R.string.poster_content_description, name.orEmpty()),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
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
            logo?.let {
                AsyncImage(
                    model = it.url,
                    contentDescription = stringResource(R.string.logo_content_description, name.orEmpty()),
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .padding(top = 30.dp)
                )
            } ?: run {
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
            }
            Text(
                text = "$year, ${genres.first().name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = { action.invoke() },
                modifier = Modifier
                    .height(56.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.save_button)
                )
            }
            Text(
                text = description.toString(),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 16.dp),
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
        MovieDetails(MovieInfoSampleData.movieDetails, {})
    }
}
