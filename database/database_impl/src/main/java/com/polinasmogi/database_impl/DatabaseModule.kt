package com.polinasmogi.database_impl

import android.content.Context
import androidx.room.Room
import com.polinasmogi.database_api.database.MoviesDao
import com.polinasmogi.database_api.database.MoviesDatabaseContract
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

private const val MOVIES_DATABASE_NAME = "MOVIES_DB"

@Module
class DatabaseModule {

    @Provides
    @Reusable
    fun provideDao(databaseContract: MoviesDatabaseContract): MoviesDao {
        return databaseContract.moviesDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MoviesDatabaseContract {
        return Room.databaseBuilder(
            context,
            MoviesDatabase::class.java, MOVIES_DATABASE_NAME
        ).build()
    }
}
