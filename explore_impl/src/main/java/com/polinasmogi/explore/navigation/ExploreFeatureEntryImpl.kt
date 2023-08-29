package com.polinasmogi.explore.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.explore.di.ExploreComponent
import com.polinasmogi.explore.ui.ExploreScreen
import com.polinasmogi.explore.viewmodel.ExploreViewModel
import com.polinasmogi.explore_api.ExploreFeatureEntry
import javax.inject.Inject

class ExploreFeatureEntryImpl @Inject constructor(
    private val appProvider: com.polinasmogi.core_api.mediator.AppProvider
): ExploreFeatureEntry {

    private val baseRoute = "explore"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val component = ExploreComponent.init(appProvider)

            val viewModel = component.viewModelFactory.create(ExploreViewModel::class.java)
            val mediator = component.provideMediator()
            ExploreScreen(viewModel = viewModel, mediator = mediator)
        }
    }
}
