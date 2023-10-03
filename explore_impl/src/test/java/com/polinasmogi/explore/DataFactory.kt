package com.polinasmogi.explore

import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.moviesapi.model.LikedMovieModel

object DataFactory {

    val movie1 = MovieToExploreModel(1, "","","","",1)
    val movie2 = MovieToExploreModel(2, "","","","",1)
    val movieList = listOf(movie1, movie2)

    val likedMovie = LikedMovieModel(1, "", "","", "")
}
