package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.DataFactory.movie1
import com.polinasmogi.explore.DataFactory.movie2
import com.polinasmogi.explore.DataFactory.movieList
import com.polinasmogi.explore.MainDispatcherRule
import com.polinasmogi.explore.interactor.ExploreInteractor
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

class ExploreViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val interactor: ExploreInteractor = mock()

    private lateinit var viewModel: ExploreViewModel

    @After
    fun after() {
        verifyNoMoreInteractions(interactor)
    }

    @Test
    fun `show first movie after the viewModel was created`() = runTest {
        // given
        whenever(interactor.getMoviesToExplore(null)).thenReturn(movieList)

        // when
        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)

        // then
        verify(interactor).getMoviesToExplore(null)
        assertEquals(movieList, viewModel.getMoviesForTest())
        assertEquals(
            ExploreUiState.MovieCard(movie1, 0),
            viewModel.uiState.value
        )
    }

    @Test(expected = Throwable::class)
    fun `show an error, if a call failed with an exception`() = runTest {
        // given
        val errorMessage = "Error message"
        whenever(interactor.getMoviesToExplore(null)).thenThrow(Throwable(errorMessage))

        // when
        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)

        // then
        verify(interactor).getMoviesToExplore(null)
        assertEquals(
            ExploreUiState.Error(errorMessage = errorMessage),
            viewModel.uiState.value
        )
    }

    @Test
    fun `show next movie, if yes button was clicked`() = runTest {
        // given
        whenever(interactor.getMoviesToExplore(null)).thenReturn(movieList)
        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)

        // when
        viewModel.onYesClicked(movie1, 0)

        // then
        verify(interactor).getMoviesToExplore(null)
        verify(interactor).onMovieLiked(movie1)
        assertEquals(listOf(movie2), viewModel.getMoviesForTest())
        assertEquals(
            ExploreUiState.MovieCard(movie2, 1),
            viewModel.uiState.value
        )
    }

    @Test
    fun `show next movie, if no button was clicked`() = runTest {
        // given
        whenever(interactor.getMoviesToExplore(null)).thenReturn(movieList)
        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)

        // when
        viewModel.onNoClicked(movie1.id, 0, movie1.page)

        // then
        verify(interactor).getMoviesToExplore(null)
        verify(interactor).onMovieDisliked(movie1.id)
        assertEquals(listOf(movie2), viewModel.getMoviesForTest())
        assertEquals(
            ExploreUiState.MovieCard(movie2, 1),
            viewModel.uiState.value
        )
    }

    @Test
    fun `get new movies, when no button was clicked and all movies were explored`() = runTest {
        // given
        val veryShortList = listOf(movie1)
        whenever(interactor.getMoviesToExplore(null)).thenReturn(veryShortList)
        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)

        // when
        viewModel.onNoClicked(movie1.id, 0, movie1.page)

        // then
        verify(interactor).getMoviesToExplore(null)
        verify(interactor).onMovieDisliked(movie1.id)
        verify(interactor).getMoviesToExplore(movie1.page)
        assertEquals(
            ExploreUiState.MovieCard(movie1, 0),
            viewModel.uiState.value
        )
    }
}
