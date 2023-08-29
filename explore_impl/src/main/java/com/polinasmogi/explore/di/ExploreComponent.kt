package com.polinasmogi.explore.di

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.explore.viewmodel.ExploreViewModelFactory
import com.polinasmogi.movies_factory.MoviesProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [MoviesProvider::class],
    modules = [ExploreModule::class]
)
interface ExploreComponent : MoviesProvider {

    companion object {

        fun init(appProvider: com.polinasmogi.core_api.mediator.AppProvider): ExploreComponent {
            return DaggerExploreComponent.builder()
                .moviesProvider(MoviesProviderFactory.createMoviesProvider(appProvider))
                .build()
        }
    }

    val viewModelFactory: ExploreViewModelFactory
}