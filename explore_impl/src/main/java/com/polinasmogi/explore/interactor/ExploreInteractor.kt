package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.models.MovieToExploreModel

interface ExploreInteractor {

    suspend fun getMoviesToExplore(page: Int? = null): List<MovieToExploreModel>

    suspend fun onMovieLiked(movie: MovieToExploreModel)

    suspend fun onMovieDisliked(movieId: Int)
}