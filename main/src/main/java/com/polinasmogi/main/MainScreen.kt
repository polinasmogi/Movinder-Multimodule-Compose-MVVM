package com.polinasmogi.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.polinasmogi.explore_api.ExploreFeatureEntry
import com.polinasmogi.main.navigation.BottomNavigationBar
import com.polinasmogi.main.navigation.Configurations
import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.partner_api.PartnerFeatureEntry
import com.polinasmogi.profile_api.ProfileFeatureEntry


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    exploreEntry: ExploreFeatureEntry,
    partnerEntry: PartnerFeatureEntry,
    profileEntry: ProfileFeatureEntry,
    movieInfoEntry: MovieInfoFeatureEntry
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val navController = rememberNavController()
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier
                    .height(56.dp),
                navController
            )
        },
    ) {
        Configurations(
            exploreEntry = exploreEntry,
            partnerEntry = partnerEntry,
            profileEntry = profileEntry,
            movieInfoEntry = movieInfoEntry,
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}

