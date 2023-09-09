package com.polinasmogi.profile.interactor

import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import javax.inject.Inject

class ProfileInteractorImpl
@Inject constructor(private val moviesRepository: BaseMoviesRepository): ProfileInteractor {

    override suspend fun getSavedMovies() = moviesRepository.getLikedMovies()
}
