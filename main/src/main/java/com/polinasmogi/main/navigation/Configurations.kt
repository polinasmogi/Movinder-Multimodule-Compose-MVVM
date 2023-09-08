package com.polinasmogi.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.polinasmogi.explore_api.ExploreFeatureEntry
import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry

@Composable
fun Configurations(
    exploreEntry: ExploreFeatureEntry,
    partnerEntry: PartnerFeatureEntry,
    profileEntry: ProfileFeatureEntry,
    movieInfoEntry: MovieInfoFeatureEntry,
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
            modifier = modifier,
            navigateTo = { movieId ->
                navController.navigate("movieInfo/$movieId")
            }
        )
        register(
            partnerEntry,
            navController = navController,
            modifier = modifier,
            navigateTo = { navController.navigate("movieInfo/$it") }
        )
        register(
            profileEntry,
            navController = navController,
            modifier = modifier,
            navigateTo = { navController.navigate("movieInfo/$it") }
        )
        composable("movieInfo/{movieId}") {
            movieInfoEntry.ShowMovieInfo(movieId = it.arguments?.getString("movieId")?.toInt())
        }
    }
}