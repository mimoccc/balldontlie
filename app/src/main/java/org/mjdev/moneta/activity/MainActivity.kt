package org.mjdev.moneta.activity

import dagger.hilt.android.AndroidEntryPoint
import org.mjdev.moneta.base.activity.ComposableActivity
import org.mjdev.moneta.base.helpers.Ext.screen
import org.mjdev.moneta.ui.screens.AboutScreen
import org.mjdev.moneta.ui.screens.MainScreen
import org.mjdev.moneta.ui.screens.DetailScreen

@AndroidEntryPoint
class MainActivity : ComposableActivity({

    screen(MainScreen())

    screen(DetailScreen())

    screen(AboutScreen())

})