package com.polinasmogi.explore.interactor

import com.polinasmogi.moviesapi.model.MovieModel

interface ExploreInteractor {

    suspend fun getMovies(): List<MovieModel>

    suspend fun onMovieLiked(movie: MovieModel)
}