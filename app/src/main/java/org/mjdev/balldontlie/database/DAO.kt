@file:Suppress("unused")

package org.mjdev.balldontlie.database

import android.content.Context
import android.os.Environment
import com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SQLiteDatabase
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.helpers.Ext.stringResource
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Team
import timber.log.Timber
import java.io.File

class DAO(
    @ApplicationContext
    val context: Context,
) : OrmLiteSqliteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION,
    R.raw.ormlite_config
) {

    companion object {

        const val DATABASE_NAME = "balldontlie"
        const val DATABASE_VERSION = 1
        // note external db needs permission
        val EXTERNAL_DB = Environment.getExternalStorageDirectory().absolutePath +
                File.separator +
                DATABASE_NAME
        const val INTERNAL_DB = DATABASE_NAME

    }

    private val dbLocation: String = EXTERNAL_DB

    val playerDao: Dao<Player, Int> get() = getDao(Player::class.java)

    val teamDao: Dao<Team, Int> get() = getDao(Team::class.java)

    override fun onCreate(
        database: SQLiteDatabase?,
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
        database: SQLiteDatabase?,
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

    @Synchronized
    fun getWritableDatabase(): SQLiteDatabase? {
        return SQLiteDatabase.openDatabase(
            dbLocation,
            password,
            null,
            SQLiteDatabase.OPEN_READWRITE
        )
    }

    @Synchronized
    fun getReadableDatabase(): SQLiteDatabase? {
        return SQLiteDatabase.openDatabase(
            dbLocation,
            password,
            null,
            SQLiteDatabase.OPEN_READONLY
        )
    }


    override fun getPassword(): String = context.stringResource(R.string.database_password)

}