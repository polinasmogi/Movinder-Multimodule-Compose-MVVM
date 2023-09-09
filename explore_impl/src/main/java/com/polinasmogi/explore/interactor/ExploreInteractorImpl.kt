package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.mappers.toLikedMovieModel
import com.polinasmogi.explore.models.MovieToExploreModel
import com.polinasmogi.explore.repository.ExploreMoviesRepository
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import javax.inject.Inject

class ExploreInteractorImpl
    @Inject constructor(
        private val exploreRepository: ExploreMoviesRepository,
        private val baseMoviesRepository: BaseMoviesRepository
    ): ExploreInteractor {

    override suspend fun getMoviesToExplore(page: Int?): List<MovieToExploreModel> {
        return exploreRepository.getMoviesToExplore()
    }

    override suspend fun onMovieLiked(movie: MovieToExploreModel) {
        baseMoviesRepository.onMovieLiked(movie.toLikedMovieModel())
        exploreRepository.removeExploredMovie(movie.id)
    }

    override suspend fun onMovieDisliked(movieId: Int) {
        exploreRepository.removeExploredMovie(movieId)
    }
}
