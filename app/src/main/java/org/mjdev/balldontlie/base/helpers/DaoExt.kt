//package org.mjdev.balldontlie.base.helpers
//
//import com.j256.ormlite.dao.Dao
//import com.j256.ormlite.dao.Dao.DaoObserver
//import com.j256.ormlite.stmt.PreparedQuery
//import kotlinx.coroutines.channels.awaitClose
//import kotlinx.coroutines.flow.callbackFlow
//
//object DaoExt {
//
////    fun <T> Dao<T, Int>.daoValueOf(
////        query: PreparedQuery<T>
////    ) = callbackFlow {
////        val observer = DaoObserver {
////            trySend(query(query).first())
////        }
////        registerObserver(observer)
////        trySend(query(query).first())
////        awaitClose {
////            unregisterObserver(observer)
////        }
////    }
//
////    fun <T> Dao<T, Int>.listOfAll() = callbackFlow {
////        val observer = DaoObserver {
////            trySend(queryForAll())
////        }
////        registerObserver(observer)
////        trySend(queryForAll())
////        awaitClose {
////            unregisterObserver(observer)
////        }
////    }
//
//}