package com.polinasmogi.explore.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.composeViewModel
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.explore.di.ExploreComponent
import com.polinasmogi.explore.ui.ExploreScreen
import com.polinasmogi.explore.viewmodel.ExploreViewModel
import com.polinasmogi.explore_api.navigation.ExploreFeatureEntry
import javax.inject.Inject

class ExploreFeatureEntryImpl @Inject constructor(
    private val appProvider: AppProvider
): ExploreFeatureEntry {

    private val baseRoute = "explore"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
        navigateTo: (Int) -> Unit
    ) {
        navGraphBuilder.composable(baseRoute) {
            val exploreViewModel: ExploreViewModel = composeViewModel {
                ExploreComponent.init(appProvider).viewModelFactory.create(ExploreViewModel::class.java)
            }
            ExploreScreen(viewModel = exploreViewModel, onMovieClick = navigateTo)
        }
    }
}
