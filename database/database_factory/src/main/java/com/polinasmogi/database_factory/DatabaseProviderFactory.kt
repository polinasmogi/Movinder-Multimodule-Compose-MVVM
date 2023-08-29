package com.polinasmogi.database_factory

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.database_api.database.DatabaseProvider
import com.polinasmogi.database_impl.DaggerDatabaseComponent

object DatabaseProviderFactory {

    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }
}
