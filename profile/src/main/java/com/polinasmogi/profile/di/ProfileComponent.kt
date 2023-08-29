package com.polinasmogi.profile.di

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.movies_factory.MoviesProviderFactory
import com.polinasmogi.moviesapi.MoviesProvider
import com.polinasmogi.profile.viewmodel.ProfileViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [MoviesProvider::class],
    modules = [ProfileModule::class],
)
interface ProfileComponent {

    companion object {

        fun init(appProvider: com.polinasmogi.core_api.mediator.AppProvider): ProfileComponent {
            return DaggerProfileComponent.builder()
                .moviesProvider(MoviesProviderFactory.createMoviesProvider(appProvider))
                .build()
        }
    }

    val viewModelFactory: ProfileViewModelFactory
}