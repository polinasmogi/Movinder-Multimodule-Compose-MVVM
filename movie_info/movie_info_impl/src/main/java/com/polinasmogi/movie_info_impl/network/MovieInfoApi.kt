package com.polinasmogi.movie_info_impl.network

import com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieInfoApi {

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int
    ): MovieInfoResponse
}