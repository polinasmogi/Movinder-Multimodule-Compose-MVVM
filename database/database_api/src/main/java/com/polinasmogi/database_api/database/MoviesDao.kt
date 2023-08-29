package com.polinasmogi.database_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.polinasmogi.database_api.dto.MovieDto

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MOVIES")
    suspend fun getMovies(): List<MovieDto>

    @Insert
    suspend fun insertMovie(movie: MovieDto)
}
