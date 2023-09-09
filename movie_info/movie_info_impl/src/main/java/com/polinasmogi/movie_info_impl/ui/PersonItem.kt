package com.polinasmogi.movie_info_impl.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.ui_atoms.theme.MovinderTheme

@Composable
fun PersonItem(person: com.polinasmogi.movie_info_impl.network.info.Person) {
    Column(
        modifier = Modifier
            .height(90.dp)
            .width(80.dp)
    ) {
        person.apply {
            AsyncImage(
                model = photo,
                contentDescription = "$name photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .background(Color.Black)
            )
            Text(
                text = name.orEmpty(),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = profession.orEmpty(),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MovieItemPreview() {
    MovinderTheme {
//        PersonItem(SampleData.movieDetails.persons.first())
    }
}