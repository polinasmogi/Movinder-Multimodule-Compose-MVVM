package com.polinasmogi.explore

import com.polinasmogi.explore.models.MovieToExploreModel

object DataFactory {

    val movie1 = MovieToExploreModel(1, "","","","",1)
    val movie2 = MovieToExploreModel(2, "","","","",1)
    val movieList = listOf(movie1, movie2)
}
