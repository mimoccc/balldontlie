package org.mjdev.balldontlie.sync

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Service
import android.content.ContentResolver
import android.content.ContentResolver.setIsSyncable
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import org.mjdev.balldontlie.BuildConfig
import timber.log.Timber

class SyncService : Service() {

    override fun onCreate() {
        synchronized(sSyncAdapterLock) {
            sSyncAdapter = sSyncAdapter ?: SyncAdapter(applicationContext, true)
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return sSyncAdapter?.syncAdapterBinder ?: throw IllegalStateException()
    }

    companion object {

        private const val ACCOUNT: String = BuildConfig.SYNC_AUTH
        private const val ACCOUNT_TYPE: String = BuildConfig.SYNC_AUTH
        private const val AUTHORITY: String = BuildConfig.SYNC_AUTH

        private var sSyncAdapter: SyncAdapter? = null
        private val sSyncAdapterLock = Any()

        fun Context.createSyncAccount(): Account {
            val accountManager = getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
            return Account(ACCOUNT, ACCOUNT_TYPE).also { account ->
                if (accountManager.addAccountExplicitly(account, "", Bundle())) {
                    setIsSyncable(account, AUTHORITY, 1)
                } else {
                    Timber.e("Can not create sync account")
                }
            }
        }

        fun requestSync(account: Account) =
            ContentResolver.requestSync(account, AUTHORITY, Bundle())

    }

}