package com.polinasmogi.profile.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.profile.ui.ProfileScreen
import com.polinasmogi.profile_api.ProfileFeatureEntry
import javax.inject.Inject

class ProfileFeatureEntryImpl @Inject constructor() : ProfileFeatureEntry {
//    , RootComponentHolder<ProfileComponent>

    private val baseRoute = "profile"

    override fun profileRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            ProfileScreen()
        }
    }

//    override val rootRoute: String
//        get() = baseRoute
//
//    @Composable
//    override fun rootComponent(rootEntry: NavBackStackEntry, arguments: Bundle?): ProfileComponent {
//        val facade = (LocalContext.current as AppWithFacade).getFacade()
//        return rememberScoped(storeOwner = rootEntry) {
//            DaggerProfileComponent.builder().providersFacade(facade).build()
//        }
//    }
}