package com.polinasmogi.partner.di

import com.polinasmogi.core_api.mediator.ProvidersFacade
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [PartnerExternelModule::class],
    dependencies = [com.polinasmogi.core_api.mediator.ProvidersFacade::class]
)
interface PartnerComponent