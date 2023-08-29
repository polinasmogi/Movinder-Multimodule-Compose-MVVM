package com.polinasmogi.movies.di

import com.polinasmogi.core_api.network.NetworkProvider
import com.polinasmogi.database_api.database.DatabaseProvider
import com.polinasmogi.database_factory.DatabaseProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [NetworkProvider::class, DatabaseProvider::class],
    modules = [MoviesModule::class]
)
interface MoviesComponent : MoviesProvider {

    companion object {

        fun init(appProvider: com.polinasmogi.core_api.mediator.AppProvider): MoviesComponent {
            return DaggerMoviesComponent.builder()
                .networkProvider(com.polinasmogi.core_factory.CoreProvidersFactory.createRetrofit())
                .databaseProvider(DatabaseProviderFactory.createDatabaseBuilder(appProvider))
                .build()
        }
    }
}