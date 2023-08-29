package com.polinasmogi.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieList(movies: List<String?>) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(movies) {
                it?.let { it1 -> Text(text = it1) }
            }
        }
    }
}
