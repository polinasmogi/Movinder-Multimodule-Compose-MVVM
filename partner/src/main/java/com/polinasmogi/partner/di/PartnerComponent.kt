package com.polinasmogi.partner.di

import com.polinasmogi.core_api.mediator.ProvidersFacade
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [PartnerModule::class],
    dependencies = [ProvidersFacade::class]
)
interface PartnerComponent