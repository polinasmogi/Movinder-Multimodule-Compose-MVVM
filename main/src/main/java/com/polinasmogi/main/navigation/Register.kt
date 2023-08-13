package com.polinasmogi.main.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.polinasmogi.core_api.mediator.FeatureEntry

fun NavGraphBuilder.register(
    featureMediator: FeatureEntry,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    featureMediator.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}