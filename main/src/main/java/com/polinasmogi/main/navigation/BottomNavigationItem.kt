package com.polinasmogi.main.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.polinasmogi.strings.R

sealed class BottomNavigationItem(@StringRes val nameRes: Int, val route: String, val icon: ImageVector) {
    object Explore : BottomNavigationItem(R.string.nav_item_explore, "explore", Icons.Rounded.Search)
    object Partner : BottomNavigationItem(R.string.nav_item_partner, "partner", Icons.Rounded.Home)
    object Profile : BottomNavigationItem(R.string.nav_item_profile, "profile", Icons.Rounded.Person)
}
