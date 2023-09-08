package com.polinasmogi.movie_info_api

import androidx.compose.runtime.Composable
import com.polinasmogi.core_api.mediator.FeatureEntry

interface MovieInfoFeatureEntry: FeatureEntry {

    @Composable
    fun ShowMovieInfo(movieId: Int?)
}