package com.polinasmogi.database_api.database

interface MoviesDatabaseContract {

    fun exploreMoviesDao(): ExploreMoviesDao

    fun likedMoviesDao(): LikedMoviesDao
}