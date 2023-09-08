package com.polinasmogi.moviesapi.model

import com.polinasmogi.moviesapi.network.model.model.Doc

fun Doc.toMovieModel(): MovieModel {
    val genresString = genres.joinToString(" • ") { it.name.toString() }

    return MovieModel(
        id = id,
        name = name,
        posterUrl = poster?.url,
        shortDescription = shortDescription,
        genresString = genresString
    )
}

fun List<Doc>.toMovieModels() : List<MovieModel> = map { it.toMovieModel() }
