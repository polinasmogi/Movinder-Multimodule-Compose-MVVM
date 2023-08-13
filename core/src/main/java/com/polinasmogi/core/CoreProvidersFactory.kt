package com.polinasmogi.core

import com.polinasmogi.core_api.network.NetworkProvider
import com.polinasmogi.core_impl.DaggerNetworkComponent

object CoreProvidersFactory {

    fun createRetrofit(): NetworkProvider {
        return DaggerNetworkComponent.builder().build()
    }
}