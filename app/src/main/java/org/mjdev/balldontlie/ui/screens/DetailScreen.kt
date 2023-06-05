package org.mjdev.balldontlie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayNightPreview
import org.mjdev.balldontlie.base.helpers.Ext.LaunchCoroutine
import org.mjdev.balldontlie.base.helpers.Ext.appViewModel
import org.mjdev.balldontlie.base.helpers.Ext.arg
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.base.ui.ScreenView
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.ui.components.players.PlayerDetail
import org.mjdev.balldontlie.viewmodel.DetailViewModel

typealias PLAYER_SOURCE = suspend (playerId: Int) -> Player

class DetailScreen : Screen() {

    private val argPlayerId = "playerId"

    override val titleResId: Int = R.string.title_player_detail

    override val args = listOf(
        navArgument(argPlayerId) { defaultValue = -1 }
    )

    @DayNightPreview
    @Composable
    override fun Compose() = super.Compose()

    @Composable
    override fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {

        val viewModel: DetailViewModel = appViewModel()
        val playerId = backStackEntry?.arg(argPlayerId, 0) ?: 0

        val playerSource: PLAYER_SOURCE = { viewModel.player(playerId) }

        val player: MutableState<Player> = remember { mutableStateOf(Player()) }

        ScreenView(
            navController = navController,
            title = stringResource(id = titleResId),
        ) { state, padding ->
            viewModel.handleError { error ->
                state.error(error)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (player.value.isEmpty()) {
                    state.setIsLoading()
                } else {
                    state.setIsNotLoading()
                }
                PlayerDetail(
                    modifier = Modifier.fillMaxSize(),
                    player = player.value
                )
            }
        }

        LaunchCoroutine {
            player.value = playerSource.invoke(playerId)
        }

    }

}