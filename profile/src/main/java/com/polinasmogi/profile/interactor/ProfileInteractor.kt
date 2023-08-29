package com.polinasmogi.profile.interactor

interface ProfileInteractor {

    suspend fun getSavedMovies(): List<String?>
}