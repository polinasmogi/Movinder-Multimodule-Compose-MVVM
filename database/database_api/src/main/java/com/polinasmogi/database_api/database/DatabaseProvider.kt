package com.polinasmogi.database_api.database

interface DatabaseProvider {

    fun provideDatabase(): MoviesDatabaseContract

    fun exploreMoviesDao(): ExploreMoviesDao

    fun likedMoviesDao(): LikedMoviesDao
}