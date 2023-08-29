package com.polinasmogi.explore.interactor

import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.moviesapi.model.MoviesResponse
import com.polinasmogi.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class ExploreInteractorImpl
    @Inject constructor(private val moviesRepository: MoviesRepository): ExploreInteractor {

    //a page number should be saved in prefs
    override suspend fun getMovies(): MoviesResponse {
        return moviesRepository.getMovies("1")
    }

    override suspend fun onMovieLiked(movie: Doc) {
        moviesRepository.onMovieLiked(movie)
    }
}
