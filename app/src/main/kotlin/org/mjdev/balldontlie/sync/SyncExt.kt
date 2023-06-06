//package org.mjdev.balldontlie.sync
//
//import android.content.ContentResolver
//import android.database.ContentObserver
//import android.database.Cursor
//import android.net.Uri
//import android.os.Build
//import android.os.Bundle
//import com.squareup.moshi.Moshi
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.channels.awaitClose
//import kotlinx.coroutines.flow.callbackFlow
//import kotlinx.coroutines.withContext
//import org.mjdev.balldontlie.base.helpers.Ext.fromJson
//import org.mjdev.balldontlie.model.Player
//import kotlin.coroutines.CoroutineContext
//
//object SyncExt {
//
//    private val DATA_PROJECTION = arrayOf(
//        DataProvider.COLUMNS._ID,
//        DataProvider.COLUMNS.DATA
//    )
//
//    private suspend fun ContentResolver.queryEx(
//        uri: Uri,
//        projection: Array<String>? = DATA_PROJECTION,
//        sortOrder: String = DataProvider.COLUMNS._ID,
//        offset: Int = 0,
//        limit: Int = Int.MAX_VALUE,
//        context: CoroutineContext = Dispatchers.IO,
//    ): Cursor? = withContext(context) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            query(uri, projection, Bundle().apply {
//                putInt(ContentResolver.QUERY_ARG_LIMIT, limit)
//                putInt(ContentResolver.QUERY_ARG_OFFSET, offset)
//                putStringArray(ContentResolver.QUERY_ARG_SORT_COLUMNS, arrayOf(sortOrder))
//            }, null)
//        } else {
//            query(uri, projection, "", null, sortOrder)
//        }
//    }
//
//    @Suppress("unused")
//    private fun ContentResolver.observe(uri: Uri) = callbackFlow {
//        val observer = object : ContentObserver(null) {
//            override fun onChange(selfChange: Boolean) {
//                trySend(selfChange)
//            }
//        }
//        registerContentObserver(uri, true, observer)
//        trySend(false)
//        awaitClose {
//            unregisterContentObserver(observer)
//        }
//    }
//
//    private fun Cursor.toPlayer(
//        moshi: Moshi? = null
//    ): Player = fromJson(
//        getString(DATA_PROJECTION.indexOf(DataProvider.COLUMNS.DATA)) ?: "",
//        moshi
//    )
//
//    private suspend fun ContentResolver.getPlayers(
//        offset: Int,
//        limit: Int,
//        moshi: Moshi? = null
//    ): List<Player> =
//        queryEx(
//            uri = DataProvider.CONTENT_URI_PLAYER,
//            projection = DATA_PROJECTION,
//            offset = offset,
//            limit = limit,
//        )?.let { c ->
//            List(c.count) {
//                c.moveToPosition(it)
//                c.toPlayer(moshi)
//            }
//        } ?: emptyList()
//
//    private suspend fun ContentResolver.getPlayer(
//        id: Int,
//        moshi: Moshi? = null
//    ): List<Player> =
//        queryEx(
//            uri = Uri.withAppendedPath(DataProvider.CONTENT_URI_PLAYER, "$id"),
//            projection = DATA_PROJECTION,
//            offset = 0,
//            limit = 1,
//        )?.let { c ->
//            List(c.count) {
//                c.moveToPosition(it)
//                c.toPlayer(moshi)
//            }
//        } ?: emptyList()
//
//    // todo observe(DataProvider.CONTENT_URI_PLAYER).map {}
//    suspend fun ContentResolver.players(
//        offset: Int = 0,
//        limit: Int = Int.MAX_VALUE
//    ): List<Player> {
//        val moshi: Moshi = Moshi.Builder().build()
//        return getPlayers(offset, limit, moshi)
//    }
//
//    // todo observe(DataProvider.CONTENT_URI_PLAYER).map {}
//    suspend fun ContentResolver.player(id: Int): List<Player> {
//        val moshi: Moshi = Moshi.Builder().build()
//        return getPlayer(id, moshi)
//    }
//
//}