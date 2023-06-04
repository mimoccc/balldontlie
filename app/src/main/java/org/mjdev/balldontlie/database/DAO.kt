package org.mjdev.balldontlie.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Team
import timber.log.Timber

class DAO(
    context: Context
) : OrmLiteSqliteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION,
    R.raw.ormlite_config
) {

    val playerDao: Dao<Player, Int> get() = getDao(Player::class.java)

    val teamDao: Dao<Team, Int> get() = getDao(Team::class.java)

    override fun onCreate(database: SQLiteDatabase, connectionSource: ConnectionSource) {
        try {
            TableUtils.createTable(connectionSource, Player::class.java)
            TableUtils.createTable(connectionSource, Team::class.java)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun onUpgrade(
        database: SQLiteDatabase,
        connectionSource: ConnectionSource,
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

    companion object {
        private const val DATABASE_NAME = "balldontlie"
        private const val DATABASE_VERSION = 1
    }

}