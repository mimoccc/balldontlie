package org.mjdev.balldontlie.activity

import dagger.hilt.android.AndroidEntryPoint
import org.mjdev.balldontlie.base.activity.ComposableActivity
import org.mjdev.balldontlie.base.helpers.Ext.screen
import org.mjdev.balldontlie.ui.screens.AboutScreen
import org.mjdev.balldontlie.ui.screens.MainScreen
import org.mjdev.balldontlie.ui.screens.DetailScreen

@AndroidEntryPoint
class MainActivity : ComposableActivity({

    screen(MainScreen())

    screen(DetailScreen())

    screen(AboutScreen())

})