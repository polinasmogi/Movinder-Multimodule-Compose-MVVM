package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.DataFactory.likedMovie
import com.polinasmogi.explore.DataFactory.movie1
import com.polinasmogi.explore.DataFactory.movieList
import com.polinasmogi.explore.repository.ExploreMoviesRepository
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class ExploreInteractorImplTest {

    private lateinit var interactor: ExploreInteractorImpl

    private val exploreRepository: ExploreMoviesRepository = mock()
    private val baseMoviesRepository: BaseMoviesRepository = mock()

    @Before
    fun start() {
        interactor = ExploreInteractorImpl(exploreRepository, baseMoviesRepository)
    }

    @After
    fun after() {
        verifyNoMoreInteractions(
            exploreRepository,
            baseMoviesRepository
        )
    }

    @Test
    fun `return list of movies if getMoviesToExplore() was called`() = runTest {
        // given
        whenever(exploreRepository.getMoviesToExplore(null)).thenReturn(movieList)

        // when
        val result = interactor.getMoviesToExplore()

        // then
        verify(exploreRepository).getMoviesToExplore(null)
        assertEquals(movieList, result)
    }

    @Test
    fun `save a movie, if it was liked`() = runTest {
        // when
        interactor.onMovieLiked(movie1)

        // then
        verify(exploreRepository).removeExploredMovie(movie1.id)
        verify(baseMoviesRepository).onMovieLiked(likedMovie)
    }

    @Test
    fun `remove a movie, if it was disliked`() = runTest {
        // when
        interactor.onMovieDisliked(movie1.id)

        // then
        verify(exploreRepository).removeExploredMovie(movie1.id)
    }
}
