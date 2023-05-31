package org.mjdev.moneta.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import org.mjdev.moneta.R
import org.mjdev.moneta.base.helpers.Ext.hiltViewModel
import org.mjdev.moneta.base.navigation.MenuItem
import org.mjdev.moneta.base.navigation.Screen
import org.mjdev.moneta.base.navigation.StartDestination
import org.mjdev.moneta.base.ui.ScreenView
import org.mjdev.moneta.ui.components.players.PlayersList
import org.mjdev.moneta.viewmodel.MainViewModel

@StartDestination
class MainScreen : Screen() {

    override val titleResId = R.string.app_name

    override val args = listOf<NamedNavArgument>()

    override val menuResId: Int = R.string.menu_Item_home

    @Preview(showBackground = true)
    @Composable
    override fun Compose() = super.Compose()

    @Composable
    override fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {

        val viewModel: MainViewModel? = hiltViewModel()
        val playersData = viewModel?.players()?.collectAsLazyPagingItems()

        ScreenView(
            navController = navController,
            title = stringResource(titleResId),
            menuItems = menuItems
        ) { state, padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                viewModel?.handleError { error ->
                    state.error(error)
                }
                playersData?.loadState?.refresh?.also { loadState ->
                    state.setLoadingState(loadState)
                }
                PlayersList(
                    playersData = playersData,
                    onItemClick = { player ->
                        open<DetailScreen>(navController, player?.id)
                    }
                )
            }
        }

    }

}