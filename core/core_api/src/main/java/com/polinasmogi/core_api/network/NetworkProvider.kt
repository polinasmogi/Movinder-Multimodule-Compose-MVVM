package com.polinasmogi.core_api.network

import retrofit2.Retrofit

interface NetworkProvider {

    fun provideRetrofit() : Retrofit
}