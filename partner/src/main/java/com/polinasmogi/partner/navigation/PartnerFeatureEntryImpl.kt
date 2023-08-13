package com.polinasmogi.partner.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.polinasmogi.core_api.RootComponentHolder
import com.polinasmogi.core_api.mediator.AppWithFacade
import com.polinasmogi.core_api.rememberScoped
import com.polinasmogi.partner.di.DaggerPartnerComponent
import com.polinasmogi.partner.di.PartnerComponent
import com.polinasmogi.partner.ui.PartnerScreen
import com.polinasmogi.partner_api.PartnerFeatureEntry
import javax.inject.Inject

class PartnerFeatureEntryImpl @Inject constructor() : PartnerFeatureEntry, RootComponentHolder<PartnerComponent> {

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

    override val rootRoute: String = baseRoute //?

    @Composable
    override fun rootComponent(
        rootEntry: NavBackStackEntry,
        arguments: Bundle?
    ): PartnerComponent {
        val facade = (LocalContext.current as AppWithFacade).getFacade()
        return rememberScoped(storeOwner = rootEntry) {
            DaggerPartnerComponent.builder().providersFacade(facade).build()
        }
    }
}