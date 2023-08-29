package com.polinasmogi.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.polinasmogi.explore_api.ExploreFeatureEntry
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry

@Composable
fun Configurations(
    exploreEntry: ExploreFeatureEntry,
    partnerEntry: PartnerFeatureEntry,
    profileEntry: ProfileFeatureEntry,
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.Explore.route
    ) {
        register(
            exploreEntry,
            navController = navController,
            modifier = modifier
        )
        register(
            partnerEntry,
            navController = navController,
            modifier = modifier
        )
        register(
            profileEntry,
            navController = navController,
            modifier = modifier
        )
    }
}