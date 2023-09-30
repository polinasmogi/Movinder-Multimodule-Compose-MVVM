package com.polinasmogi.movie_info_impl.data

import com.polinasmogi.movie_info_impl.network.info.Genres
import com.polinasmogi.movie_info_impl.network.info.Logo
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.movie_info_impl.network.info.Person
import com.polinasmogi.movie_info_impl.network.info.Poster

object MovieInfoSampleData {

    val actor = Person(name = "Margo Murphy")

    val movieDetails = MovieInfoResponse(
        id = 0,
        name = "Barbenheimer",
        description = "Barbenheimer is a cultural phenomenon that began before the simultaneous theatrical release of two blockbuster films: Warner Bros. ",
        year = 2023,
        poster = Poster(),
        logo = Logo(),
        genres = arrayListOf(Genres("drama")),
        persons = arrayListOf(actor, actor, actor)
    )
}