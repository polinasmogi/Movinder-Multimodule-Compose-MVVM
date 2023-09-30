package com.polinasmogi.explore.interactor

import com.polinasmogi.explore.DataFactory.movieList
import com.polinasmogi.explore.repository.ExploreMoviesRepository
import com.polinasmogi.moviesapi.repository.BaseMoviesRepository
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.mock
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class ExploreInteractorImplTest {


    private lateinit var interactor: ExploreInteractorImpl

    private val exploreRepository: ExploreMoviesRepository = mock()
    private val baseMoviesRepository: BaseMoviesRepository = mock()

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
        whenever(exploreRepository.getMoviesToExplore(anyInt())).thenReturn(movieList)

        // when

        // then
    }
}