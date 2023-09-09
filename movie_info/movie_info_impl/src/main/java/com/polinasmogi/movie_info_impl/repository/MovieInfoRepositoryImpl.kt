package com.polinasmogi.movie_info_impl.repository

import com.polinasmogi.movie_info_impl.network.MovieInfoApi
import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import javax.inject.Inject

class MovieInfoRepositoryImpl
    @Inject constructor(
        private val api: MovieInfoApi
    ): MovieInfoRepository {

    override suspend fun getMovieById(movieId: Int): MovieInfoResponse =
        api.getMovieById(movieId)
}