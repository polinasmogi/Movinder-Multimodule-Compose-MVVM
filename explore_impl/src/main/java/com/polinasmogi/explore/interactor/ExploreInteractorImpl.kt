package com.polinasmogi.explore.interactor

import com.polinasmogi.moviesapi.model.toMovieModels
import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class ExploreInteractorImpl
    @Inject constructor(private val moviesRepository: MoviesRepository): ExploreInteractor {

    private var page = 1

    //a page number should be saved in prefs
    override suspend fun getMovies(): List<MovieModel> {
        val response = moviesRepository.getMovies(page.toString())
        page = response.page?.plus(1) ?: 1
        return response.docs.filter { it.countries.size == 1 }.toMovieModels()
    }

    override suspend fun onMovieLiked(movie: MovieModel) {
        moviesRepository.onMovieLiked(movie)
    }
}
