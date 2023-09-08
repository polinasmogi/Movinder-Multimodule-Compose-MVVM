package com.polinasmogi.main.di

import com.polinasmogi.core_api.mediator.ProvidersFacade
import com.polinasmogi.main.MainActivity
import dagger.Component

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [MainModule::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(mainActivity: MainActivity)
}