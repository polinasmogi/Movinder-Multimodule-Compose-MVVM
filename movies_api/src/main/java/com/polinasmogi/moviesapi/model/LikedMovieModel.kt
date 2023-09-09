package com.polinasmogi.moviesapi.model

data class LikedMovieModel (
    val id               : Int,
    val name             : String,
    val shortDescription : String?,
    val posterUrl        : String?,
    val genresString     : String?
)
