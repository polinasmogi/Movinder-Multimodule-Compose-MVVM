package com.polinasmogi.movie_info_impl.interactor

import com.polinasmogi.movie_info_impl.DataFactory
import com.polinasmogi.movie_info_impl.repository.MovieInfoRepositoryImpl
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class MovieInfoInteractorImplTest {

    private lateinit var interactor: MovieInfoInteractorImpl

    private val movieInfoRepository: MovieInfoRepositoryImpl = mock()
    private val baseMoviesRepository: BaseMoviesRepository = mock()

    @Before
    fun start() {
        interactor = MovieInfoInteractorImpl(movieInfoRepository, baseMoviesRepository)
    }

    @After
    fun after() {
        verifyNoMoreInteractions(
            movieInfoRepository,
            movieInfoRepository
        )
    }

    @Test
    fun `return movie info from server`() = runTest {
        // given
        whenever(movieInfoRepository.getMovieById(1)).thenReturn(DataFactory.movie)

        // when
        val result = interactor.getMovieById(1)

        // then
        verify(movieInfoRepository).getMovieById(1)
        Assert.assertEquals(DataFactory.movie, result)
    }

    @Test
    fun `save movie if liked`() = runTest {
        // when
        interactor.onMovieLiked(DataFactory.movie)

        // then
        verify(baseMoviesRepository).onMovieLiked(DataFactory.likedMovie)
    }
}
