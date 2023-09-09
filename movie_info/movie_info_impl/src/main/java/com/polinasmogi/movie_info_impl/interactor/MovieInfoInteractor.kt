package com.polinasmogi.movie_info_impl.interactor

import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import com.polinasmogi.moviesapi.model.LikedMovieModel

interface MovieInfoInteractor {

    suspend fun getMovieById(movieId: Int): MovieInfoResponse

    suspend fun onMovieLiked(movie: LikedMovieModel)
}