package com.polinasmogi.explore.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.explore.di.ExploreComponent
import com.polinasmogi.explore.ui.ExploreScreen
import com.polinasmogi.explore.viewmodel.ExploreViewModel
import com.polinasmogi.explore_api.ExploreFeatureEntry
import javax.inject.Inject

class ExploreFeatureEntryImpl @Inject constructor(): ExploreFeatureEntry {

    private val baseRoute = "explore"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        val viewModel = ExploreComponent.init().viewModelFactory.create(ExploreViewModel::class.java)
        navGraphBuilder.composable(baseRoute) {
            ExploreScreen(viewModel = viewModel)
        }
    }
}
