package com.polinasmogi.profile.di

import com.polinasmogi.profile.navigation.ProfileFeatureEntryImpl
import com.polinasmogi.profile_api.ProfileFeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ProfileExternalModule {

    @Binds
    @IntoMap
    @ClassKey(ProfileFeatureEntry::class)
    fun bindMediator(mediator: ProfileFeatureEntryImpl): Any
}