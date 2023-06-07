@file:Suppress("unused")

package org.mjdev.balldontlie.database

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import io.objectbox.Box
import org.mjdev.balldontlie.model.MyObjectBox
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Team
import io.objectbox.kotlin.boxFor

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
) {

    companion object {

        /**
         * Database name
         */
        const val DATABASE_NAME = "balldontlie"


    }

    /**
     * Players data access property
     */
    val playerDao: Box<Player> get() = MyObjectBox.builder()
        .androidContext(context.applicationContext)
        .name(DATABASE_NAME)
        .build()
        .boxFor()

    /**
     * Teams db access property
     */
    val teamDao: Box<Team> get() = MyObjectBox.builder()
        .androidContext(context.applicationContext)
        .name(DATABASE_NAME)
        .build()
        .boxFor()

}