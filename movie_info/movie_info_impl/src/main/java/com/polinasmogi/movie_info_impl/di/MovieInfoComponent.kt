package com.polinasmogi.movie_info_impl.di

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModelFactory
import com.polinasmogi.movies_factory.MoviesProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [MoviesProvider::class],
    modules = [MovieInfoModule::class]
)
interface MovieInfoComponent : MoviesProvider {

    companion object {

        fun init(appProvider: AppProvider): MovieInfoComponent {
            return DaggerMovieInfoComponent.builder()
                .moviesProvider(MoviesProviderFactory.createMoviesProvider(appProvider))
                .build()
        }
    }

    val viewModelFactory: MovieInfoViewModelFactory
}