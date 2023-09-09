package com.polinasmogi.main.di

import com.polinasmogi.explore_api.navigation.ExploreFeatureEntry
import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface MainModule {

    companion object{

        @Provides
        fun provideExploreFeatureEntry(
            map: Map<Class<*>,
            @JvmSuppressWildcards Provider<Any>>
        ): ExploreFeatureEntry {
            return map[ExploreFeatureEntry::class.java]!!.get() as ExploreFeatureEntry
        }

        @Provides
        fun providePartnerFeatureEntry(
            map: Map<Class<*>,
            @JvmSuppressWildcards Provider<Any>>
        ): PartnerFeatureEntry {
            return map[PartnerFeatureEntry::class.java]!!.get() as PartnerFeatureEntry
        }

        @Provides
        fun provideProfileFeatureEntry(
            map: Map<Class<*>,
            @JvmSuppressWildcards Provider<Any>>
        ): ProfileFeatureEntry {
            return map[ProfileFeatureEntry::class.java]!!.get() as ProfileFeatureEntry
        }

        @Provides
        fun provideMovieInfoFeatureEntry(
            map: Map<Class<*>,
            @JvmSuppressWildcards Provider<Any>>
        ): MovieInfoFeatureEntry {
            return map[MovieInfoFeatureEntry::class.java]!!.get() as MovieInfoFeatureEntry
        }
    }
}