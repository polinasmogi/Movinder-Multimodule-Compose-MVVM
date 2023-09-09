package com.polinasmogi.database_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.polinasmogi.database_api.dto.ExploreMovieEntity

@Dao
interface ExploreMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviesToExplore(movies: List<ExploreMovieEntity>)

    @Query("SELECT * FROM MOVIES_TO_EXPLORE")
    suspend fun getMoviesToExplore(): List<ExploreMovieEntity>

    @Query("DELETE FROM MOVIES_TO_EXPLORE WHERE id = :id")
    suspend fun deleteExploredMovie(id: Int)
}