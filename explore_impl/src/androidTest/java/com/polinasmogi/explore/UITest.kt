package com.polinasmogi.explore

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import com.polinasmogi.explore.ui.MoviesExplorer
import com.polinasmogi.ui_atoms.theme.MovinderTheme
import org.junit.Rule
import org.junit.Test

class UITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonIsVisibleForShortDescriptionTest() {
        composeTestRule.setContent {
            MovinderTheme {
                MoviesExplorer(DataFactory.movieWithShortDescription, {}, {}, {})
            }
        }

        composeTestRule.onNodeWithText(DataFactory.showMoreButtonText).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.genresString).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.shortDescription).assertIsDisplayed()
    }

    @Test
    fun buttonIsNotVisibleForShortDescriptionTest() {
        composeTestRule.setContent {
            MovinderTheme {
                MoviesExplorer(DataFactory.movieWithLongDescription, {}, {}, {})
            }
        }

        composeTestRule.onNodeWithText(DataFactory.genresString).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.longDescription).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.showMoreButtonText).assertIsNotDisplayed()
    }

    @Test
    fun buttonIsVisibleAfterSwipeUpTest() {
        composeTestRule.setContent {
            MovinderTheme {
                MoviesExplorer(DataFactory.movieWithLongDescription, {}, {}, {})
            }
        }

        composeTestRule.onNodeWithText(DataFactory.longDescription).apply {
            performTouchInput { swipeUp() }
            performTouchInput { swipeUp() }
            performTouchInput { swipeUp() }
        }

        composeTestRule.onNodeWithText(DataFactory.genresString).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.longDescription).assertIsDisplayed()
        composeTestRule.onNodeWithText(DataFactory.showMoreButtonText).assertIsDisplayed()
    }
}
