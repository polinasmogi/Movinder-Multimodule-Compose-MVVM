package com.polinasmogi.movie_info_impl.repository

import com.polinasmogi.movie_info_impl.DataFactory.movie
import com.polinasmogi.movie_info_impl.network.MovieInfoApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class MovieInfoRepositoryImplTest {

    private lateinit var repository: MovieInfoRepositoryImpl

    private val moviesApi: MovieInfoApi = mock()

    @Before
    fun start() {
        repository = MovieInfoRepositoryImpl(moviesApi)
    }

    @After
    fun after() {
        verifyNoMoreInteractions(moviesApi)
    }

    @Test
    fun `return movie info from server`() = runTest {
        // given
        whenever(moviesApi.getMovieById(1)).thenReturn(movie)

        // when
        val result = repository.getMovieById(1)

        // then
        verify(moviesApi).getMovieById(1)
        assertEquals(movie, result)
    }
}
