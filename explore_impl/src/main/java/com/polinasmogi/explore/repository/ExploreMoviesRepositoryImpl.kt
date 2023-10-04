package com.polinasmogi.explore.repository

import com.polinasmogi.database_api.database.ExploreMoviesDao
import com.polinasmogi.explore.mappers.docListToModels
import com.polinasmogi.explore.mappers.entityListToModels
import com.polinasmogi.explore.mappers.toEntities
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.explore.network.ExploreMoviesApi
import javax.inject.Inject

class ExploreMoviesRepositoryImpl
    @Inject constructor(
        private val moviesApi: ExploreMoviesApi,
        private val moviesDao: ExploreMoviesDao
    ): ExploreMoviesRepository {

    override suspend fun getMoviesToExplore(page: Int?): List<MovieToExploreModel> {
        moviesDao.getMoviesToExplore().let {
            if (it.isEmpty())
                return getMoviesFromServer(page ?: 1)
            else
                return it.entityListToModels()
        }
    }

    private suspend fun getMoviesFromServer(page: Int): List<MovieToExploreModel> {
        moviesApi
            .getMovies(page.toString(), country = null, type = null)
            .docs
            .apply {
                moviesDao.insertMoviesToExplore(this.toEntities(page))
                return this.docListToModels(page)
            }
    }

    override suspend fun removeExploredMovie(movieId: Int) {
        moviesDao.deleteExploredMovie(movieId)
    }
}