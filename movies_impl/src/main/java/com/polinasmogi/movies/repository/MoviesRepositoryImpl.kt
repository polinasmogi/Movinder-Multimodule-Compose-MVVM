package com.polinasmogi.movies.repository

import com.polinasmogi.database_api.database.MoviesDao
import com.polinasmogi.database_api.dto.MovieDto
import com.polinasmogi.moviesapi.network.MoviesApi
import javax.inject.Inject

class MoviesRepositoryImpl
    @Inject constructor(
        private val moviesApi: MoviesApi,
        private val moviesDao: MoviesDao
    ) : com.polinasmogi.moviesapi.repository.MoviesRepository {

    override suspend fun getMovies(page: String): com.polinasmogi.moviesapi.model.MoviesResponse =
        moviesApi.getMovies(page, "Корея Южная")

    override suspend fun onMovieLiked(movie: com.polinasmogi.moviesapi.model.Doc) {
        val genreList = mutableListOf<String>()
        movie.genres.map {
            it.name?.let { it1 -> genreList.add(it1) }
        }
        val countryList = mutableListOf<String>()
        movie.countries.map {
            it.name?.let { it1 -> countryList.add(it1) }
        }
        val movieDto = movie.id?.let {
            MovieDto(
                id = it,
                name = movie.name,
                description = movie.description,
                year = movie.year,
                posterUrl = movie.poster?.url,
//                genres = genreList,
//                countries = countryList,
                shortDescription = movie.shortDescription,
                logoUrl = movie.logo?.url
            )
        }
        movieDto?.let { moviesDao.insertMovie(it) }
    }

    override suspend fun getLikedMovies(): List<String?> {
        val savedMovies = mutableListOf<String?>()
        moviesDao.getMovies().map {
            savedMovies.add(it.name.toString())
        }
        return savedMovies
    }
}
