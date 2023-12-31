package com.polinasmogi.explore.network

import com.polinasmogi.explore.network.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExploreMoviesApi {

    @GET("movie?selectFields=id&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=logo&selectFields=poster&selectFields=genres&selectFields=year&selectFields=countries&limit=50")
    suspend fun getMovies(
        @Query("page") page: String,
        @Query("countries.name") country: String?,
        @Query("type") type: String?
    ): MoviesResponse
}