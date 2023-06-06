package org.mjdev.balldontlie.repository.impl

import com.j256.ormlite.dao.Dao
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
    ): Result<Players> = Result.success(
        playersStore.query(
            playersStore.queryBuilder()
                .offset(page.toLong())
                .limit(
                    perPage.toLong()
                ).prepare()
        ).let { list ->
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
    ): Result<Player> = Result.success(
        playersStore.query(
            playersStore.queryBuilder()
                .where().eq("id", id)
                .prepare()
        ).first()
    )

}