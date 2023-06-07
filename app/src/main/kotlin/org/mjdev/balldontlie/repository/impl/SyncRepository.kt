package org.mjdev.balldontlie.repository.impl

import io.objectbox.Box
import org.mjdev.balldontlie.database.DAO
import org.mjdev.balldontlie.model.Meta
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.def.IRepository.Companion.runSafe
import javax.inject.Inject

@Suppress("MemberVisibilityCanBePrivate")
class SyncRepository @Inject constructor(
    var dao: DAO
) : IRepository {

    private val playersStore: Box<Player> get() = dao.playerDao

    override suspend fun getPlayers(
        page: Int,
        perPage: Int,
    ): Result<Players> = runSafe {
        playersStore.all.let { list ->
            if (list.size > (perPage * page))
                list.subList(
                    page,
                    perPage
                )
            else emptyList<Player>()
        }.let { list ->
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
    }

    override suspend fun getPlayer(
        id: Int
    ): Result<Player> = runSafe {
        playersStore.get(id.toLong())
    }

}