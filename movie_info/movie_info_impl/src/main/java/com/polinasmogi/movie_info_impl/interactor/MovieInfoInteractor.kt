package com.polinasmogi.movie_info_impl.interactor

import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.model.info.MovieInfoResponse

interface MovieInfoInteractor {

    suspend fun getMovieById(movieId: Int): MovieInfoResponse

    suspend fun onMovieLiked(movie: MovieModel)
}