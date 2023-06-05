package org.mjdev.balldontlie.application

import android.app.Application
import com.google.android.material.color.DynamicColors
import dagger.hilt.android.HiltAndroidApp
import org.mjdev.balldontlie.sync.SyncService
import org.mjdev.balldontlie.sync.SyncService.Companion.createSyncAccount

@HiltAndroidApp
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
        initializeDBSQLCipher()
        createSyncAccount()?.also { account ->
            SyncService.requestSync(account)
        }
        // todo account time to time can not be prepared
    }

    private fun initializeDBSQLCipher() {
        System.loadLibrary("sqlcipher")
    }

}