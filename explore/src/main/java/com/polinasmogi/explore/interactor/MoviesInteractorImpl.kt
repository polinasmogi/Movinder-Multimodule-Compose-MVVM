package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.data.model.MoviesResponse
import com.polinasmogi.explore.data.repository.MoviesRepository
import javax.inject.Inject

class MoviesInteractorImpl
    @Inject constructor(private val moviesRepository: MoviesRepository): MoviesInteractor {

    //a page number should be saved in prefs
    override suspend fun getMovies(): MoviesResponse {
        return moviesRepository.getMovies("1")
    }
}
