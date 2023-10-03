package com.polinasmogi.movie_info_impl.mappers

import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.moviesapi.model.LikedMovieModel

fun MovieInfoResponse.toLikedMovieModel() : LikedMovieModel {
    val genresString = genres.joinToString(" • ") { it.name.toString() }

    return LikedMovieModel(
        id = id ?: 0,
        name = name.orEmpty(),
        posterUrl = poster?.url,
        shortDescription = description,
        genresString = genresString
    )
}
