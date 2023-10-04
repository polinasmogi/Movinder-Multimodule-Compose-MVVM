package com.polinasmogi.explore

import com.polinasmogi.database_api.dto.ExploreMovieEntity
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.explore.network.model.Doc
import com.polinasmogi.explore.network.model.Genres
import com.polinasmogi.explore.network.model.MoviesResponse
import com.polinasmogi.explore.network.model.Poster
import com.polinasmogi.moviesapi.model.LikedMovieModel

object DataFactory {

    val movie1 = MovieToExploreModel(1, "","","","",1)
    val movie2 = MovieToExploreModel(2, "","","","",1)
    val movieList = listOf(movie1, movie2)

    val likedMovie = LikedMovieModel(1, "", "","", "")

    val movieFromServer = Doc(
        1,
        "Barbenheimer",
        Poster("url", ""),
        "",
        listOf(Genres("drama"), Genres("history")),
        listOf()
    )
    val listFromServer = listOf(movieFromServer)
    val responseFromServer = MoviesResponse(listFromServer, 1, 1, 1,1)

    val movieEntity = ExploreMovieEntity(
        id = 1,
        name = "Barbenheimer",
        posterUrl = "url",
        shortDescription = "",
        genresString = "drama • history",
        page = 1
    )
    val movieEntityList = listOf(movieEntity)

    val movieToExploreModel = MovieToExploreModel(
        id = 1,
        name = "Barbenheimer",
        posterUrl = "url",
        shortDescription = "",
        genresString = "drama • history",
        page = 1
    )
    val movieToExploreList = listOf(movieToExploreModel)
}
