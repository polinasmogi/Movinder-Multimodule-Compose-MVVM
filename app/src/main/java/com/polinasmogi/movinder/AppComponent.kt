package com.polinasmogi.movinder

import android.content.Context
import com.polinasmogi.core_api.mediator.AppProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent : com.polinasmogi.core_api.mediator.AppProvider {

    companion object {

        private var appComponent: com.polinasmogi.core_api.mediator.AppProvider? = null

        fun create(applicationContext: Context): com.polinasmogi.core_api.mediator.AppProvider {
            return appComponent ?: DaggerAppComponent
                .builder()
                .application(applicationContext)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}