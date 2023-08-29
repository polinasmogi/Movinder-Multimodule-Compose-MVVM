package com.polinasmogi.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polinasmogi.profile.di.ProfileModule
import com.polinasmogi.profile.interactor.ProfileInteractor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class ProfileViewModelFactory @Inject constructor(
    private val interactor: ProfileInteractor,
    @Named(ProfileModule.IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(interactor, ioDispatcher) as T
    }
}
