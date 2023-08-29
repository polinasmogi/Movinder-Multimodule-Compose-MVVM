package com.polinasmogi.core_impl.network

import com.polinasmogi.core_api.network.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent : com.polinasmogi.core_api.network.NetworkProvider