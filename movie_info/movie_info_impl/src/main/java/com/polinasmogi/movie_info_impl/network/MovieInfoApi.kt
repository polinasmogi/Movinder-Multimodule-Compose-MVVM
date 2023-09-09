package com.polinasmogi.movie_info_impl.network

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieInfoApi {

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int
    ): com.polinasmogi.movie_info_impl.network.info.MovieInfoResponse
}