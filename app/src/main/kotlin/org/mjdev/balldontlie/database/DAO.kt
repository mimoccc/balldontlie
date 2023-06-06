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

/**
 * Dao.
 *
 * Database access object
 *
 * @constructor Create [DAO]
 * @property context
 */
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

        /**
         * Database name
         */
        const val DATABASE_NAME = "balldontlie"

        /**
         * Database version
         */
        const val DATABASE_VERSION = 1

        /**
         * External database path
         * Note : Needs permissions
         */
        val EXTERNAL_DB = Environment.getExternalStorageDirectory().absolutePath +
                File.separator +
                DATABASE_NAME

        /**
         * Internal database path
         */
        const val INTERNAL_DB = DATABASE_NAME

    }

    /**
     * DB location
     * Can be [EXTERNAL_DB] or [INTERNAL_DB]
     */
    private val dbLocation: String = INTERNAL_DB

    /**
     * Players data access property
     */
    val playerDao: Dao<Player, Int> get() = getDao(Player::class.java)

    /**
     * Teams db access property
     */
    val teamDao: Dao<Team, Int> get() = getDao(Team::class.java)

    /**
     * On create.
     *
     * This function is called when database does not exists to create
     *
     * @param database Database
     * @param connectionSource Connection source
     */
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

    /**
     * On upgrade.
     *
     * If version change this function is called
     *
     * @param database Database
     * @param connectionSource Connection source
     * @param oldVersion Old version
     * @param newVersion New version
     */
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

    /**
     * Get writable database.
     *
     * @return [SQLiteDatabase] or null
     */
    @Synchronized
    fun getWritableDatabase(): SQLiteDatabase? {
        return SQLiteDatabase.openDatabase(
            dbLocation,
            password,
            null,
            SQLiteDatabase.OPEN_READWRITE
        )
    }

    /**
     * Get readable database.
     *
     * @return [SQLiteDatabase] or null
     */
    @Synchronized
    fun getReadableDatabase(): SQLiteDatabase? {
        return SQLiteDatabase.openDatabase(
            dbLocation,
            password,
            null,
            SQLiteDatabase.OPEN_READONLY
        )
    }

    /**
     * Get password.
     *
     * Function is used to encrypt database
     *
     * @return
     */
    override fun getPassword(): String = context.stringResource(R.string.database_password)

}