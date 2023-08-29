package com.polinasmogi.profile.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.profile.di.ProfileComponent
import com.polinasmogi.profile.ui.ProfileScreen
import com.polinasmogi.profile.viewmodel.ProfileViewModel
import com.polinasmogi.profile_api.ProfileFeatureEntry
import javax.inject.Inject

class ProfileFeatureEntryImpl @Inject constructor(
    private val appProvider: com.polinasmogi.core_api.mediator.AppProvider
) : ProfileFeatureEntry {

    private val baseRoute = "profile"

    override fun profileRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val viewModel = ProfileComponent.init(appProvider).viewModelFactory
                .create(ProfileViewModel::class.java)
            ProfileScreen(viewModel = viewModel)
        }
    }
}
