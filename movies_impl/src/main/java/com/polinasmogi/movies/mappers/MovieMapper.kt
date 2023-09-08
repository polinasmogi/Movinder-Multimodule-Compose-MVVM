package com.polinasmogi.movies.mappers

import com.polinasmogi.database_api.dto.LikedMovieEntity
import com.polinasmogi.moviesapi.model.MovieModel

fun MovieModel.toLikedMovieEntity(): LikedMovieEntity {

    return LikedMovieEntity(
        id = id,
        name = name,
        posterUrl = posterUrl,
        genresString = genresString,
        shortDescription = shortDescription
    )
}

fun LikedMovieEntity.toMovieModel(): MovieModel {

    return MovieModel(
        id = id,
        name = name,
        shortDescription = shortDescription,
        posterUrl = posterUrl,
        genresString = genresString
    )
}

fun List<LikedMovieEntity>.toMovieModels() = map { it.toMovieModel() }
