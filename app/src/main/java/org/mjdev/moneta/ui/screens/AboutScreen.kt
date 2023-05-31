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
import org.mjdev.moneta.R
import org.mjdev.moneta.base.navigation.MenuItem
import org.mjdev.moneta.base.navigation.Screen
import org.mjdev.moneta.base.ui.ScreenView
import org.mjdev.moneta.ui.components.about.About

class AboutScreen : Screen() {

    override val titleResId = R.string.title_about

    override val args = listOf<NamedNavArgument>()

    override val menuResId: Int = R.string.menu_item_about

    @Preview(showBackground = true)
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