package com.polinasmogi.moviesapi.network

import com.polinasmogi.moviesapi.model.info.MovieInfoResponse
import com.polinasmogi.moviesapi.network.model.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie?selectFields=id&selectFields=name&selectFields=description&selectFields=shortDescription&selectFields=logo&selectFields=poster&selectFields=genres&selectFields=year&selectFields=countries&limit=50")
    suspend fun getMovies(
        @Query("page") page: String,
        @Query("countries.name") country: String,
        @Query("type") type: String
    ): MoviesResponse

    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Int
    ): MovieInfoResponse
}
