package com.polinasmogi.moviesapi.ui

import androidx.compose.runtime.Composable
import com.polinasmogi.moviesapi.model.Doc

interface MovieInfoMediator {

    @Composable
    fun ShowMovieInfo(movie: Doc)
}