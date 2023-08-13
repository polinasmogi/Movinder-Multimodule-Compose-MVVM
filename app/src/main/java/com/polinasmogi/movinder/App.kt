package com.polinasmogi.movinder

import android.app.Application
import com.polinasmogi.core_api.mediator.AppWithFacade
import com.polinasmogi.core_api.mediator.ProvidersFacade

class App: Application(), AppWithFacade {

    companion object {

        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        getFacade()
    }

}