package com.polinasmogi.main.di

import com.polinasmogi.explore_api.ExploreFeatureEntry
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface MainModule {

    companion object{

        @Provides
        fun provideMediator1(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): ExploreFeatureEntry {
            return map[ExploreFeatureEntry::class.java]!!.get() as ExploreFeatureEntry
        }

        @Provides
        fun provideMediator2(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): PartnerFeatureEntry {
            return map[PartnerFeatureEntry::class.java]!!.get() as PartnerFeatureEntry
        }

        @Provides
        fun provideMediator3(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): ProfileFeatureEntry {
            return map[ProfileFeatureEntry::class.java]!!.get() as ProfileFeatureEntry
        }
    }
}