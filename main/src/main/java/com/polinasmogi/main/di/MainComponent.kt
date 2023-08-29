package com.polinasmogi.main.di

import com.polinasmogi.core_api.mediator.ProvidersFacade
import com.polinasmogi.main.MainActivity
import dagger.Component

@Component(
    dependencies = [com.polinasmogi.core_api.mediator.ProvidersFacade::class],
    modules = [MainModule::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: com.polinasmogi.core_api.mediator.ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(mainActivity: MainActivity)
}