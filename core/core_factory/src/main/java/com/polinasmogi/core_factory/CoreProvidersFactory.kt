package com.polinasmogi.core_factory

import com.polinasmogi.core_api.network.NetworkProvider
import com.polinasmogi.core_impl.network.DaggerNetworkComponent

object CoreProvidersFactory {

    fun createRetrofit(): NetworkProvider {
        return DaggerNetworkComponent.builder().build()
    }
}
