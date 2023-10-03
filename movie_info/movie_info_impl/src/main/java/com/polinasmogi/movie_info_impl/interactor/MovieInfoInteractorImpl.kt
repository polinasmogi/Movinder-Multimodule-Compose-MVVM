package com.polinasmogi.movie_info_impl.interactor

import com.polinasmogi.movie_info_impl.mappers.toLikedMovieModel
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.movie_info_impl.repository.MovieInfoRepository
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import javax.inject.Inject

class MovieInfoInteractorImpl
    @Inject constructor(
        private val movieInfoRepository: MovieInfoRepository,
        private val baseMoviesRepository: BaseMoviesRepository
    ): MovieInfoInteractor {

    override suspend fun getMovieById(movieId: Int): MovieInfoResponse =
        movieInfoRepository.getMovieById(movieId)

    override suspend fun onMovieLiked(movie: MovieInfoResponse) {
        baseMoviesRepository.onMovieLiked(movie.toLikedMovieModel())
    }
}
