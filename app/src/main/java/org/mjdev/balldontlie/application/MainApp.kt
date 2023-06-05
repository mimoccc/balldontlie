package org.mjdev.balldontlie.application

import android.app.Application
import com.google.android.material.color.DynamicColors
import dagger.hilt.android.HiltAndroidApp
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.helpers.Ext.stringResource
import org.mjdev.balldontlie.sync.SyncService
import org.mjdev.balldontlie.sync.SyncService.Companion.createSyncAccount
import net.sqlcipher.database.SQLiteDatabase

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
        val name = stringResource(R.string.app_name)
        val dbName = "$name.db"
        System.loadLibrary("sqlcipher")
        val databaseFile = getDatabasePath(dbName)
        val database = SQLiteDatabase.openOrCreateDatabase(
            databaseFile,
            name,
            null,
            null
        )
        if (database != null) {
            database.execSQL("create table t1(a,b);")
            database.execSQL(
                "insert into t1(a,b) values(?, ?);",
                arrayOf("", "")
            )
        }
    }

}