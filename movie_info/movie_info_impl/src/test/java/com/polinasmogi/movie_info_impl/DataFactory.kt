package com.polinasmogi.movie_info_impl

import com.polinasmogi.movie_info_impl.network.info.Genres
import com.polinasmogi.movie_info_impl.network.info.Logo
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.movie_info_impl.network.info.Poster
import com.polinasmogi.moviesapi.model.LikedMovieModel

object DataFactory {

    val movie = MovieInfoResponse(
        id = 1,
        name = "Barbenheimer",
        description = "",
        year = 2023,
        poster = Poster("url"),
        logo = Logo(),
        genres = listOf(Genres("drama"), Genres("history")),
        persons = listOf()
    )

    val likedMovie = LikedMovieModel(
        1,
        "Barbenheimer",
        "",
        "url",
        "drama • history"
    )
}
