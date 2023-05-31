package org.mjdev.moneta.base.helpers

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavigatorProvider
import androidx.navigation.compose.composable
import org.mjdev.moneta.BuildConfig
import org.mjdev.moneta.base.navigation.NavGraphBuilderEx
import org.mjdev.moneta.base.navigation.Screen
import timber.log.Timber
import kotlin.reflect.KClass

object Ext {

    @Composable
    fun NavHost(
        modifier: Modifier = Modifier,
        route: String? = null,
        navController: NavHostController,
        builder: NavGraphBuilderEx.() -> Unit
    ) {
        androidx.navigation.compose.NavHost(
            navController,
            remember(route, builder) {
                navController.createGraph(
                    route,
                    navController,
                    builder
                )
            },
            modifier
        )
    }

    private inline fun NavController.createGraph(
        route: String? = null,
        navController: NavHostController,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = navigatorProvider.navigation(navController, route, builder)

    private inline fun NavigatorProvider.navigation(
        navController: NavHostController,
        route: String? = null,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = NavGraphBuilderEx(this, route, navController)
        .apply(builder)
        .build()

    fun <T : Screen> NavGraphBuilderEx.screen(route: T) {
        if (route.isStartDestination) {
            startDestinationRouteEx = route.completeRoute
        }
        route.menuItem?.also { menuItem ->
            menuItems.add(menuItem)
        }
        composable(
            route = route.completeRoute,
            arguments = route.args
        ) { be ->
            route.Compose(navHostController, be, menuItems)
        }
    }

    @Composable
    inline fun <reified VM : ViewModel> hiltViewModel(
        viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
        },
        crossinline initBlock: VM.() -> Unit = {}
    ): VM {
        val context = LocalContext.current
        return if (context !is Activity)
            createMockViewModel()
        else viewModel<VM>(
            viewModelStoreOwner = viewModelStoreOwner,
            factory = createHiltViewModelFactory(viewModelStoreOwner)
        ).apply {
            initBlock(this)
        }
    }

    // todo may be not working on render view
    inline fun <reified VM> createMockViewModel(): VM {
        return VM::class.constructors.firstOrNull {
            it.parameters.isEmpty()
        }?.call() as VM
    }

    @Composable
    @PublishedApi
    internal fun createHiltViewModelFactory(
        viewModelStoreOwner: ViewModelStoreOwner
    ): ViewModelProvider.Factory? = if (viewModelStoreOwner is NavBackStackEntry) {
        HiltViewModelFactory(
            context = LocalContext.current,
            navBackStackEntry = viewModelStoreOwner
        )
    } else {
        null
    }

    fun NavBackStackEntry.arg(
        argId: String,
        defaultValue: Int
    ): Int? = arguments?.getInt(argId, defaultValue)

}