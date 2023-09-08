package com.polinasmogi.movie_info_impl.interactor

import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.model.info.MovieInfoResponse
import com.polinasmogi.moviesapi.repository.MoviesRepository
import javax.inject.Inject

class MovieInfoInteractorImpl
    @Inject constructor(private val moviesRepository: MoviesRepository): MovieInfoInteractor {

    override suspend fun getMovieById(movieId: Int): MovieInfoResponse =
        moviesRepository.getMovieById(movieId)

    override suspend fun onMovieLiked(movie: MovieModel) {
        moviesRepository.onMovieLiked(movie)
    }
}
