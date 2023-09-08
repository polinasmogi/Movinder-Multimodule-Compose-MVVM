package com.polinasmogi.movie_info_impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.mediator.AppProvider
import com.polinasmogi.movie_info_impl.viewmodel.MovieInfoViewModel
import com.polinasmogi.movie_info_api.MovieInfoFeatureEntry
import com.polinasmogi.movie_info_impl.di.MovieInfoComponent
import javax.inject.Inject

class MovieInfoFeatureEntryImpl @Inject constructor(
    private val appProvider: AppProvider
): MovieInfoFeatureEntry {

    @Composable
    override fun ShowMovieInfo(movieId: Int?) {
        val viewModelState = remember { mutableStateOf<MovieInfoViewModel?>(null) }.apply {
            value?.let { viewModel ->
                MovieInfoScreen(viewModel, movieId)
            }
        }
        LaunchedEffect(true) {
            val component = MovieInfoComponent.init(appProvider)
            val viewModel = component.viewModelFactory.create(MovieInfoViewModel::class.java)
            viewModelState.value = viewModel
        }
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
        navigateTo: (Int) -> Unit
    ) {
        navGraphBuilder.composable("movieInfo/{movieId}") {
//            val viewModelState = remember { mutableStateOf<MovieInfoViewModel?>(null) }.apply {
//                value?.let { viewModel ->
//                    MovieInfoScreen(viewModel, it.arguments?.getString("movieId")?.toInt())
//                }
//            }
//            LaunchedEffect(true) {
//                val component = MovieInfoComponent.init(appProvider)
//                val viewModel = component.viewModelFactory.create(MovieInfoViewModel::class.java)
//                viewModelState.value = viewModel
//            }
            val component = MovieInfoComponent.init(appProvider)
            val viewModel = component.viewModelFactory.create(MovieInfoViewModel::class.java)
            MovieInfoScreen(viewModel, it.arguments?.getString("movieId")?.toInt())
        }
    }
}