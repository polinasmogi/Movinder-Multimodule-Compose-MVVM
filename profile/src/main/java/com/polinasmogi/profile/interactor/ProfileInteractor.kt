package com.polinasmogi.profile.interactor

import com.polinasmogi.moviesapi.model.LikedMovieModel

interface ProfileInteractor {

    suspend fun getSavedMovies(): List<LikedMovieModel>
}