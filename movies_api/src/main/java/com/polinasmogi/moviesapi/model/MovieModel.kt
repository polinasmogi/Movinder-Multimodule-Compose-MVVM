package com.polinasmogi.moviesapi.model

data class MovieModel (
    val id               : Int,
    val name             : String,
    val shortDescription : String?,
    val posterUrl        : String?,
    val genresString     : String?
)
