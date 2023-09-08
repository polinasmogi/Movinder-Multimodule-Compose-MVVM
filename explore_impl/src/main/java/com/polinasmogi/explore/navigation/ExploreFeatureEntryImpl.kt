package com.polinasmogi.explore.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
            val viewModelState = remember { mutableStateOf<ExploreViewModel?>(null) }.apply {
                value?.let { exploreViewModel ->
                    ExploreScreen(viewModel = exploreViewModel, onMovieClick = navigateTo)
                }
            }
            LaunchedEffect(true) {
                val component = ExploreComponent.init(appProvider)
                val viewModel = component.viewModelFactory.create(ExploreViewModel::class.java)
                viewModelState.value = viewModel
            }
        }
    }
}
