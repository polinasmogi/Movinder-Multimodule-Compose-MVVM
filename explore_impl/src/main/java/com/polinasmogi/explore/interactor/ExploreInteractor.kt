package com.polinasmogi.explore.interactor

interface ExploreInteractor {

    suspend fun getMovies(): com.polinasmogi.moviesapi.model.MoviesResponse

    suspend fun onMovieLiked(movie: com.polinasmogi.moviesapi.model.Doc)
}