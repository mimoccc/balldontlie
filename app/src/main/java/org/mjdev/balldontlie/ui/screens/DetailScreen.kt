package org.mjdev.balldontlie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.NightPreview
import org.mjdev.balldontlie.base.helpers.Ext.appViewModel
import org.mjdev.balldontlie.base.helpers.Ext.arg
import org.mjdev.balldontlie.base.helpers.Ext.collectAsState
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.base.ui.ScreenView
import org.mjdev.balldontlie.ui.components.players.PlayerDetail
import org.mjdev.balldontlie.viewmodel.DetailViewModel

@NightPreview
class DetailScreen : Screen() {

    private val argPlayerId = "playerId"

    override val titleResId: Int = R.string.title_player_detail

    override val args = listOf(
        navArgument(argPlayerId) { defaultValue = -1 }
    )

    @Preview(showBackground = true)
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
        val playerData: State<Player?> = remember {
            viewModel.player(playerId)
        }.collectAsState(Player())
        val player = playerData.value

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
                if (player == null) {
                    state.error("No player data show. Check internet connection.")
                } else if (player.isEmpty()) {
                    state.setIsLoading()
                } else {
                    state.setIsNotLoading()
                }
                PlayerDetail(
                    modifier = Modifier.fillMaxSize(),
                    player = player
                )
            }
        }

    }

}