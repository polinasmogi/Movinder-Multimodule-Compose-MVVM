package com.polinasmogi.explore

import com.polinasmogi.explore.models.MovieToExploreModel

object DataFactory {

    val name = "Barbenheimer"
    val showMoreButtonText = "Описание, актёры, узнать больше…"
    val shortDescription = "There once was a ship that put to sea"
    val longDescription = "There once was a ship that put to sea\n" +
            "The name of the ship was the Billy O' Tea\n" +
            "The winds blew up, her bow dipped down\n" +
            "Oh blow, my bully boys, blow (huh)\n" +
            "Soon may the Wellerman come\n" +
            "To bring us sugar and tea and rum\n" +
            "One day, when the tonguing is done\n" +
            "We'll take our leave and go"
    val genresString = "drama"

    val movieWithShortDescription = MovieToExploreModel(
        id = 0,
        name = name,
        shortDescription = shortDescription,
        posterUrl = "",
        genresString = genresString,
        page = 1
    )

    val movieWithLongDescription = MovieToExploreModel(
        id = 0,
        name = name,
        shortDescription = longDescription,
        posterUrl = "",
        genresString = genresString,
        page = 1
    )

}