package com.polinasmogi.partner.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.partner.ui.PartnerScreen
import com.polinasmogi.partner_api.PartnerFeatureEntry
import javax.inject.Inject

class PartnerFeatureEntryImpl @Inject constructor() : PartnerFeatureEntry {

    private val baseRoute = "partner"
    override fun partnerRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            PartnerScreen()
        }
    }
}
