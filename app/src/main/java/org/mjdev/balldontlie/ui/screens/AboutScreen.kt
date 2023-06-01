package org.mjdev.balldontlie.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayNightPreview
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.base.ui.ScreenView
import org.mjdev.balldontlie.ui.components.about.About

class AboutScreen : Screen() {

    override val titleResId = R.string.title_about

    override val args = listOf<NamedNavArgument>()

    override val menuResId: Int = R.string.menu_item_about

    override val menuIcon: ImageVector get() = Icons.Filled.AccountBox

    @DayNightPreview
    @Composable
    override fun Compose() = super.Compose()

    @Composable
    override fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {
        ScreenView(
            navController = navController,
            title = stringResource(titleResId),
        ) { state, padding ->
            state.setIsNotLoading()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                About()
            }
        }
    }

}