package com.polinasmogi.core_api

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

interface RootComponentHolder<C : Any> {

    val rootRoute: String

    @Composable
    fun rootComponent(
        currentEntry: NavBackStackEntry,
        navController: NavHostController,
        arguments: Bundle?
    ): C {
        val rootEntry = currentEntry.rememberBackStackEntry(navController, route = rootRoute)
        return rootComponent(rootEntry, arguments)
    }

    @Composable
    fun rootComponent(
        rootEntry: NavBackStackEntry,
        arguments: Bundle?
    ): C
}

@Composable
fun NavBackStackEntry.rememberBackStackEntry(
    navController: NavHostController,
    route: String
): NavBackStackEntry {
    return remember(this) { navController.getBackStackEntry(route) }
}

@Composable
fun <C : Any> rememberScoped(
    storeOwner: ViewModelStoreOwner,
    key: String? = null,
    builder: () -> C
): C {
    val factory = remember(key) {
        object : ViewModelProvider.Factory {
            override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                @Suppress("UNCHECKED_CAST")
                return ScopedStore(builder()) as VM
            }
        }
    }
    val store: ScopedStore<C> = viewModel(storeOwner, key, factory)
    return store.value
}

private class ScopedStore<T : Any>(val value: T) : ViewModel()