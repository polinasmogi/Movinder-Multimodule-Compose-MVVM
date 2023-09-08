package com.polinasmogi.profile.interactor

import com.polinasmogi.moviesapi.model.MovieModel

interface ProfileInteractor {

    suspend fun getSavedMovies(): List<MovieModel>
}