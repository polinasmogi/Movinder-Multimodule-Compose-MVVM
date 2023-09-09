package com.polinasmogi.explore.repository

import com.polinasmogi.explore.models.MovieToExploreModel

interface ExploreMoviesRepository {

    suspend fun getMoviesToExplore(page: Int? = null) : List<MovieToExploreModel>

    suspend fun removeExploredMovie(movieId: Int)
}