package com.polinasmogi.explore.di

import android.app.Application
import com.polinasmogi.core.CoreProvidersFactory
import com.polinasmogi.core_api.network.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [NetworkProvider::class],
    modules = [ExploreModule::class]
)
interface ExploreComponent : NetworkProvider {

    companion object {

        fun init(): ExploreComponent =
            DaggerExploreComponent.builder()
                .networkProvider(CoreProvidersFactory.createRetrofit())
                .build()
    }
}