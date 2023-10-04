package com.polinasmogi.explore.repository

import com.polinasmogi.database_api.database.ExploreMoviesDao
import com.polinasmogi.explore.DataFactory.movieEntityList
import com.polinasmogi.explore.DataFactory.movieToExploreList
import com.polinasmogi.explore.DataFactory.movieToExploreModel
import com.polinasmogi.explore.DataFactory.responseFromServer
import com.polinasmogi.explore.network.ExploreMoviesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class ExploreMoviesRepositoryImplTest {

    private lateinit var repository: ExploreMoviesRepositoryImpl

    private val moviesApi: ExploreMoviesApi = mock()
    private val moviesDao: ExploreMoviesDao = mock()

    @Before
    fun start() {
        repository = ExploreMoviesRepositoryImpl(moviesApi, moviesDao)
    }

    @After
    fun after() {
        verifyNoMoreInteractions(
            moviesApi,
            moviesDao
        )
    }

    @Test
    fun `return movies from server, if DB is empty `() = runTest {
        // given
        whenever(moviesDao.getMoviesToExplore()).thenReturn(emptyList())
        whenever(moviesApi.getMovies("1", null, null)).thenReturn(responseFromServer)

        // when
        val result = repository.getMoviesToExplore(1)

        // then
        verify(moviesDao).getMoviesToExplore()
        verify(moviesDao).insertMoviesToExplore(movieEntityList)
        verify(moviesApi).getMovies("1", null, null)
        Assert.assertEquals(movieToExploreList, result)
    }

    @Test
    fun `return movies from database, if they were saved`() = runTest {
        // given
        whenever(moviesDao.getMoviesToExplore()).thenReturn(movieEntityList)

        // when
        val result = repository.getMoviesToExplore(1)

        // then
        verify(moviesDao).getMoviesToExplore()
        Assert.assertEquals(movieToExploreList, result)
    }

    @Test
    fun `call dao to remove an explored movie`() = runTest {
        // when
        repository.removeExploredMovie(movieToExploreModel.id)

        // then
        verify(moviesDao).deleteExploredMovie(movieToExploreModel.id)
    }
}