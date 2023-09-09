package com.polinasmogi.explore.mappers

import com.polinasmogi.database_api.dto.ExploreMovieEntity
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.explore.network.model.Doc
import com.polinasmogi.moviesapi.model.LikedMovieModel


fun Doc.docToModel(page: Int): MovieToExploreModel {
    val genresString = genres.joinToString(" • ") { it.name.toString() }

    return MovieToExploreModel(
        id = id,
        name = name,
        posterUrl = poster?.url,
        shortDescription = shortDescription,
        genresString = genresString,
        page = page
    )
}

fun List<Doc>.docListToModels(page: Int) : List<MovieToExploreModel> = map { it.docToModel(page) }

fun ExploreMovieEntity.entityToModel() =
    MovieToExploreModel(
        id = id,
        name = name,
        posterUrl = posterUrl,
        shortDescription = shortDescription,
        genresString = genresString,
        page = page
    )

fun List<ExploreMovieEntity>.entityListToModels() : List<MovieToExploreModel> = map { it.entityToModel() }

fun Doc.docToEntity(page: Int): ExploreMovieEntity {
    val genresString = genres.joinToString(" • ") { it.name.toString() }

    return ExploreMovieEntity(
        id = id,
        name = name,
        posterUrl = poster?.url,
        shortDescription = shortDescription,
        genresString = genresString,
        page = page
    )
}

fun List<Doc>.toEntities(page: Int) : List<ExploreMovieEntity> = map { it.docToEntity(page) }

fun MovieToExploreModel.toLikedMovieModel() =
    LikedMovieModel(
        id = id,
        name = name,
        posterUrl = posterUrl,
        shortDescription = shortDescription,
        genresString = genresString
    )
