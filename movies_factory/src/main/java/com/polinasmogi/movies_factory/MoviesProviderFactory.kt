package com.polinasmogi.movies_factory

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.movies.di.MoviesComponent
import com.polinasmogi.moviesapi.MoviesProvider

object MoviesProviderFactory {

    fun createMoviesProvider(appProvider: AppProvider): MoviesProvider {
        return MoviesComponent.init(appProvider)
    }
}
