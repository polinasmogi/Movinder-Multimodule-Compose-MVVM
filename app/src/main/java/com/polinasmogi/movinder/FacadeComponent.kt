package com.polinasmogi.movinder

import android.app.Application
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.core_api.mediator.ProvidersFacade
import com.polinasmogi.explore.di.ExploreExternalModule
import com.polinasmogi.partner.di.PartnerExternelModule
import com.polinasmogi.profile.di.ProfileExternalModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [
        ExploreExternalModule::class,
        PartnerExternelModule::class,
        ProfileExternalModule::class,
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