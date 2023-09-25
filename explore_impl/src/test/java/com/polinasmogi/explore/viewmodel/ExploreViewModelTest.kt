package com.polinasmogi.explore.viewmodel

import com.polinasmogi.explore.interactor.ExploreInteractor
import com.polinasmogi.explore.models.MovieToExploreModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExploreViewModelTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var interactor: ExploreInteractor

    private lateinit var viewModel: ExploreViewModel

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
        interactor = mock(ExploreInteractor::class.java)
    }

    @Test
    fun `show first movie after the viewModel was created`() = runTest {
        val givenResult = listOf(
            MovieToExploreModel(1, "","","","",1),
            MovieToExploreModel(1, "","","","",1)
        )
        `when`(interactor.getMoviesToExplore(null)).thenReturn(givenResult)

        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)


        verify(interactor).getMoviesToExplore(null)

        assertEquals(
            ExploreUiState.Loading,
            viewModel.uiState.value
        )
    }

    @Test
    fun `show next movie if the yes button was clicked`() = runTest {
        // when
        val movie = MovieToExploreModel(1, "","","","",1)

        viewModel = ExploreViewModel(interactor, mainDispatcherRule.testDispatcher)


        viewModel.onYesClicked(movie, 0)


        verify(interactor).getMoviesToExplore(null)

        assertEquals(
            ExploreUiState.MovieCard(movie, 1),
            viewModel.uiState.value
        )
    }
}


class MainDispatcherRule @OptIn(ExperimentalCoroutinesApi::class) constructor(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}
