package com.polinasmogi.database_api.database

import com.polinasmogi.database_api.database.MoviesDao
import com.polinasmogi.database_api.database.MoviesDatabaseContract

interface DatabaseProvider {

    fun provideDatabase(): MoviesDatabaseContract

    fun habitsDao(): MoviesDao
}