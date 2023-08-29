package com.polinasmogi.movies.ui

import androidx.compose.runtime.Composable
import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.moviesapi.ui.MovieInfoMediator
import javax.inject.Inject

class MovieInfoMediatorImpl @Inject constructor(): MovieInfoMediator {

    @Composable
    override fun ShowMovieInfo(movie: Doc) {
        MovieInfo(movie)
    }
}