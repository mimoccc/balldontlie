package org.mjdev.balldontlie.activity

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import org.mjdev.balldontlie.base.activity.ComposableActivity
import org.mjdev.balldontlie.base.helpers.Ext.screen
import org.mjdev.balldontlie.sync.SyncService.Companion.createSyncAccount
import org.mjdev.balldontlie.sync.SyncService.Companion.requestSync
import org.mjdev.balldontlie.ui.screens.AboutScreen
import org.mjdev.balldontlie.ui.screens.MainScreen
import org.mjdev.balldontlie.ui.screens.DetailScreen

@AndroidEntryPoint
class MainActivity : ComposableActivity({

    screen(MainScreen())

    screen(DetailScreen())

    screen(AboutScreen())

}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val account = createSyncAccount()
        if (account != null) requestSync(account)
    }

}