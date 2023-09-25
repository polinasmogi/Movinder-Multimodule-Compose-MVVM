package com.polinasmogi.movie_info_impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.composeViewModel
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.movie_info_impl.di.MovieInfoComponent
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModel
import javax.inject.Inject

class MovieInfoFeatureEntryImpl @Inject constructor(
    private val appProvider: AppProvider
): MovieInfoFeatureEntry {

    @Composable
    override fun ShowMovieInfo(movieId: Int?) {
        val viewModel = composeViewModel {
            MovieInfoComponent.init(appProvider).viewModelFactory.create(MovieInfoViewModel::class.java)
        }
        MovieInfoScreen(viewModel, movieId)
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
        navigateTo: (Int) -> Unit
    ) {
        navGraphBuilder.composable("movieInfo/{movieId}") {
            val viewModel = composeViewModel {
                MovieInfoComponent.init(appProvider).viewModelFactory.create(MovieInfoViewModel::class.java)
            }
            MovieInfoScreen(viewModel, it.arguments?.getString("movieId")?.toInt())
        }
    }
}