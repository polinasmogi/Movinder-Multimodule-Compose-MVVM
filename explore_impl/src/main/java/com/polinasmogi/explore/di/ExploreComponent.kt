package com.polinasmogi.explore.di

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.core_api.network.NetworkProvider
import com.polinasmogi.core_factory.CoreProvidersFactory
import com.polinasmogi.database_api.database.DatabaseProvider
import com.polinasmogi.database_factory.DatabaseProviderFactory
import com.polinasmogi.explore.viewmodel.ExploreViewModelFactory
import com.polinasmogi.movies_factory.MoviesProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        MoviesProvider::class,
        NetworkProvider::class,
        DatabaseProvider::class],
    modules = [ExploreModule::class]
)
interface ExploreComponent : MoviesProvider {

    companion object {

        fun init(appProvider: AppProvider): ExploreComponent {
            return DaggerExploreComponent.builder()
                .networkProvider(CoreProvidersFactory.createRetrofit())
                .databaseProvider(DatabaseProviderFactory.createDatabaseBuilder(appProvider))
                .moviesProvider(MoviesProviderFactory.createMoviesProvider(appProvider))
                .build()
        }
    }

    val viewModelFactory: ExploreViewModelFactory
}