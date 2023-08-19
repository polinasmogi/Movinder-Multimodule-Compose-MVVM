package com.polinasmogi.explore.data.network

import com.polinasmogi.explore.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie?selectFields=id&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=logo&selectFields=poster&selectFields=genres&selectFields=year&selectFields=countries&limit=50")
    suspend fun getMovies(
        @Query("page") page: String
    ): MoviesResponse
}