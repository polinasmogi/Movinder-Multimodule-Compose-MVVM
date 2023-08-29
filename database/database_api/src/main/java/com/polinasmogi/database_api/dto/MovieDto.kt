package com.polinasmogi.database_api.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MOVIES")
data class MovieDto (
    @PrimaryKey
    val id: Int,
    val name: String?,
    val description: String?,
    val year: Int?,
    val posterUrl: String?,
    val shortDescription: String?,
    val logoUrl: String?
)
