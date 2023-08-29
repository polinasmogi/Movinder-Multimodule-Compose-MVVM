package com.polinasmogi.profile.interactor

import com.polinasmogi.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class ProfileInteractorImpl
@Inject constructor(private val moviesRepository: MoviesRepository): ProfileInteractor {

    override suspend fun getSavedMovies() = moviesRepository.getLikedMovies()
}
