package com.polinasmogi.database_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.polinasmogi.database_api.database.MoviesDatabaseContract
import com.polinasmogi.database_api.dto.LikedMovieEntity

@Database(entities = [LikedMovieEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase(), MoviesDatabaseContract