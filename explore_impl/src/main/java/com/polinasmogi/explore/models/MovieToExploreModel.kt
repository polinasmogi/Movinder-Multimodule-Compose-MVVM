package com.polinasmogi.explore.models

data class MovieToExploreModel(
    val id               : Int,
    val name             : String,
    val shortDescription : String?,
    val posterUrl        : String?,
    val genresString     : String?,
    val page             : Int
)
