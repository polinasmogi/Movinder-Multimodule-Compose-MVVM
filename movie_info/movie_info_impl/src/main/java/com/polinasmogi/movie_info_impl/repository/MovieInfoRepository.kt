package com.polinasmogi.movie_info_impl.repository

interface MovieInfoRepository {

    suspend fun getMovieById(movieId: Int) : com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
}