package org.mjdev.balldontlie.activity

import dagger.hilt.android.AndroidEntryPoint
import org.mjdev.balldontlie.base.activity.ComposableActivity
import org.mjdev.balldontlie.base.helpers.Ext.screen
import org.mjdev.balldontlie.ui.screens.AboutScreen
import org.mjdev.balldontlie.ui.screens.MainScreen
import org.mjdev.balldontlie.ui.screens.DetailScreen

/**
 * Main activity.
 *
 * Simply one, start activity, for compose project.
 *
 * @constructor Create empty constructor for main activity, and keep it empty,
 * or override to empty constructor call.
 */
@AndroidEntryPoint
class MainActivity : ComposableActivity({

    screen(MainScreen(), isHomeScreen = true)

    screen(DetailScreen())

    screen(AboutScreen())

})