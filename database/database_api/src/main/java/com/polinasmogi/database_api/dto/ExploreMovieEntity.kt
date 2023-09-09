package com.polinasmogi.database_api.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MOVIES_TO_EXPLORE")
data class ExploreMovieEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val posterUrl: String?,
    val genresString: String?,
    val shortDescription: String?,
    val page: Int
)