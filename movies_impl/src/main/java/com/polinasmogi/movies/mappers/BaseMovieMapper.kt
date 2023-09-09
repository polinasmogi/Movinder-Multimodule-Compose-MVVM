package com.polinasmogi.movies.mappers

import com.polinasmogi.database_api.dto.LikedMovieEntity
import com.polinasmogi.moviesapi.model.LikedMovieModel

fun LikedMovieModel.toLikedMovieEntity() =
    LikedMovieEntity(
        id = id,
        name = name,
        shortDescription = shortDescription,
        posterUrl = posterUrl,
        genresString = genresString
    )

fun LikedMovieEntity.toMovieModel(): LikedMovieModel {

    return LikedMovieModel(
        id = id,
        name = name,
        shortDescription = shortDescription,
        posterUrl = posterUrl,
        genresString = genresString
    )
}

fun List<LikedMovieEntity>.toMovieModels() = map { it.toMovieModel() }
