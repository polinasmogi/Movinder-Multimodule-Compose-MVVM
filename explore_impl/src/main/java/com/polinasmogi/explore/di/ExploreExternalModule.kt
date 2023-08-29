package com.polinasmogi.explore.di

import com.polinasmogi.explore.navigation.ExploreFeatureEntryImpl
import com.polinasmogi.explore_api.ExploreFeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ExploreExternalModule {

    @Binds
    @IntoMap
    @ClassKey(ExploreFeatureEntry::class)
    fun bindExploreFeatureEntry(mediator: ExploreFeatureEntryImpl): Any
}
