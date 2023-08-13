package com.polinasmogi.explore.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.explore.ui.ExploreScreen
import com.polinasmogi.explore_api.ExploreFeatureEntry
import javax.inject.Inject

class ExploreFeatureEntryImpl @Inject constructor() : ExploreFeatureEntry {
//    , RootComponentHolder<ExploreComponent> {

    private val baseRoute = "explore"

    override fun exploreRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            ExploreScreen()
        }
    }

//    override val rootRoute: String
//        get() = baseRoute
//
//    @Composable
//    override fun rootComponent(rootEntry: NavBackStackEntry, arguments: Bundle?): ExploreComponent {
//        val facade = (LocalContext.current as AppWithFacade).getFacade()
//        return rememberScoped(storeOwner = rootEntry) {
//            DaggerExploreComponent.builder().providersFacade(facade).build()
//        }
//    }
}
