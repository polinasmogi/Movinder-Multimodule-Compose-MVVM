package com.polinasmogi.profile.di

import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.profile.interactor.ProfileInteractor
import com.polinasmogi.profile.interactor.ProfileInteractorImpl
import com.polinasmogi.profile.viewmodel.ProfileViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
interface ProfileModule {

    @Binds
    @Singleton
    fun bindsInteractor(interactorImpl: ProfileInteractorImpl): ProfileInteractor

    @Binds
    fun bindsViewModelFactory(viewModelFactory: ProfileViewModelFactory): ViewModelProvider.Factory

    companion object {

        const val IO = "IO"

        @Provides
        @Singleton
        @Named(IO)
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}