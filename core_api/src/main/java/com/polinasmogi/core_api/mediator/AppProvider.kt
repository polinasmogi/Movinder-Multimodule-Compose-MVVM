package com.polinasmogi.core_api.mediator

import android.content.Context

interface AppProvider {

    fun provideContext(): Context
}