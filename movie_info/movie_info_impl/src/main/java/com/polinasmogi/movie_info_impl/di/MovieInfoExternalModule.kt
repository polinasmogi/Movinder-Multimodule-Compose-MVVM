package com.polinasmogi.movie_info_impl.di

import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.movie_info_impl.ui.MovieInfoFeatureEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface MovieInfoExternalModule {

    @Binds
    @IntoMap
    @ClassKey(MovieInfoFeatureEntry::class)
    fun bindMovieInfoFeatureEntry(mediator: MovieInfoFeatureEntryImpl): Any
}
