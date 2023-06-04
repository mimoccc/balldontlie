package org.mjdev.balldontlie.repository.impl

import com.j256.ormlite.dao.Dao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mjdev.balldontlie.base.helpers.DaoExt.daoValueOf
import org.mjdev.balldontlie.base.helpers.DaoExt.listOfAll
import org.mjdev.balldontlie.database.DAO
import org.mjdev.balldontlie.model.Meta
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players
import org.mjdev.balldontlie.repository.def.IRepository
import javax.inject.Inject

@Suppress("MemberVisibilityCanBePrivate")
class SyncRepository @Inject constructor(
    var dao: DAO
) : IRepository {

    private val playersStore: Dao<Player, Int> get() = dao.playerDao

    override suspend fun getPlayers(
        page: Int,
        perPage: Int,
    ): Result<Flow<Players>> = Result.success(
        playersStore.listOfAll().map { list ->
            Players(
                players = list,
                meta = Meta(
                    currentPage = page,
                    perPage = list.size,
                    totalCount = list.size,
                    totalPages = 1
                )
            )
        }
    )

    override suspend fun getPlayer(
        id: Int
    ): Result<Flow<Player>> = Result.success(
        playersStore.daoValueOf(
            playersStore.queryBuilder()
                .where().eq("id", id)
                .prepare()
        )
    )

}