package com.polinasmogi.movies.di

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.database_api.database.DatabaseProvider
import com.polinasmogi.database_factory.DatabaseProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [DatabaseProvider::class],
    modules = [MoviesModule::class]
)
interface MoviesComponent : MoviesProvider {

    companion object {

        fun init(appProvider: AppProvider): MoviesComponent {
            return DaggerMoviesComponent.builder()
                .databaseProvider(DatabaseProviderFactory.createDatabaseBuilder(appProvider))
                .build()
        }
    }
}