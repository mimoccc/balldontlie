package org.mjdev.balldontlie.database

import android.content.Context
import com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.helpers.Ext.stringResource
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Team
import timber.log.Timber

class DAO(
    val context: Context
) : OrmLiteSqliteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION,
    R.raw.ormlite_config
) {

    val playerDao: Dao<Player, Int> get() = getDao(Player::class.java)

    val teamDao: Dao<Team, Int> get() = getDao(Team::class.java)

    override fun onCreate(
        database: net.sqlcipher.database.SQLiteDatabase?,
        connectionSource: ConnectionSource?
    ) {
        try {
            TableUtils.createTable(connectionSource, Player::class.java)
            TableUtils.createTable(connectionSource, Team::class.java)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun onUpgrade(
        database: net.sqlcipher.database.SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {
        try {
            TableUtils.dropTable<Player, Any>(connectionSource, Player::class.java, false)
            TableUtils.dropTable<Player, Any>(connectionSource, Player::class.java, false)
            onCreate(database, connectionSource)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun getPassword(): String = context.stringResource(R.string.database_password)

    companion object {
        private const val DATABASE_NAME = "balldontlie"
        private const val DATABASE_VERSION = 1
    }

}