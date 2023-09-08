package com.polinasmogi.database_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polinasmogi.database_api.dto.LikedMovieEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MOVIES")
    suspend fun getLikedMovies(): List<LikedMovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie: LikedMovieEntity)
}
