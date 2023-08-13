package com.polinasmogi.partner.di

import com.polinasmogi.partner.navigation.PartnerFeatureEntryImpl
import com.polinasmogi.partner_api.PartnerFeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface PartnerModule {

    @Binds
    @IntoMap
    @ClassKey(PartnerFeatureEntry::class)
    fun bindMediator(mediator: PartnerFeatureEntryImpl): Any
}