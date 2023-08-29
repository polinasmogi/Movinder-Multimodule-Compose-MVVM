package com.polinasmogi.database_impl

import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.database_api.database.DatabaseProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseProvider