package org.mjdev.balldontlie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.NightPreview
import org.mjdev.balldontlie.base.helpers.Ext.appViewModel
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.base.annotations.StartDestination
import org.mjdev.balldontlie.base.ui.ScreenView
import org.mjdev.balldontlie.ui.components.players.PlayersList
import org.mjdev.balldontlie.viewmodel.MainViewModel

@NightPreview
@StartDestination
class MainScreen : Screen() {

    override val titleResId = R.string.app_name

    override val args = listOf<NamedNavArgument>()

    override val menuResId: Int = R.string.menu_Item_home

    override val menuIcon: ImageVector get() = Icons.Filled.Home

    @Preview(showBackground = true)
    @Composable
    override fun Compose() = super.Compose()

    @Composable
    override fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {

        val viewModel: MainViewModel = appViewModel()
        val players = remember { viewModel.players() }?.collectAsLazyPagingItems()

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
                viewModel.handleError { error ->
                    state.error(error)
                }
                players?.loadState?.refresh?.also { loadState ->
                    state.setLoadingState(loadState)
                }
                PlayersList(
                    players = players,
                    onItemClick = { player ->
                        open<DetailScreen>(navController, player?.id)
                    }
                )
            }
        }

    }

}