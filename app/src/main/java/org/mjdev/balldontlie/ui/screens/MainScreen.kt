package org.mjdev.balldontlie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayNightPreview
import org.mjdev.balldontlie.base.helpers.Ext.appViewModel
import org.mjdev.balldontlie.base.helpers.SOURCE
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.base.ui.ScreenView
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.ui.components.players.PlayersList
import org.mjdev.balldontlie.viewmodel.MainViewModel

class MainScreen : Screen() {

    override val titleResId = R.string.app_name

    override val args = listOf<NamedNavArgument>()

    override val menuResId: Int = R.string.menu_Item_home

    override val menuIcon: ImageVector get() = Icons.Filled.Home

    @DayNightPreview
    @Composable
    override fun Compose() = super.Compose()

    @Composable
    override fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {

        val viewModel: MainViewModel = appViewModel()

        val playersSource: SOURCE<Player> = { p, c ->
            // todo custom DaoSource as ListPagerSource
            viewModel.players(p, c)
        }

        ScreenView(
            navController = navController,
            title = stringResource(titleResId),
            menuItems = menuItems
        ) { state, padding ->

            viewModel.handleError { error ->
                state.error(error)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                PlayersList(
                    source = { p, c ->
                        playersSource.invoke(p, c)
                    },
                    onItemClick = { player ->
                        open<DetailScreen>(navController, player.id)
                    },
                    loadStateHandler = { loadState ->
                        state.loadingState.value = loadState
                    }
                )

            }

        }

    }

}