package com.polinasmogi.movinder

import android.app.Application
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.core_api.mediator.ProvidersFacade
import com.polinasmogi.explore.di.ExploreExternalModule
import com.polinasmogi.partner.di.PartnerModule
import com.polinasmogi.profile.di.ProfileModule
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [
        ExploreExternalModule::class,
        PartnerModule::class,
        ProfileModule::class
    ]
)
interface FacadeComponent : ProvidersFacade {

    companion object {

        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .build()
    }
}