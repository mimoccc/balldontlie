package org.mjdev.balldontlie.sync

import android.accounts.Account
import android.content.AbstractThreadedSyncAdapter
import android.content.ContentProviderClient
import android.content.Context
import android.content.SyncResult
import android.os.Bundle
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.mjdev.balldontlie.database.DAO
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Team
import timber.log.Timber
import org.mjdev.balldontlie.base.helpers.Ext.containsNot
import org.mjdev.balldontlie.repository.def.INetworkRepository

@Suppress("unused", "PrivatePropertyName")
class SyncAdapter(
    context: Context,
    val repository: INetworkRepository,
    val dao: DAO
) : AbstractThreadedSyncAdapter(context, true, false) {

    private val READ_COUNT = 50

    private val playersStore: Box<Player> get() = dao.playerDao
    private val teamsStore: Box<Team> get() = dao.teamDao

    override fun onPerformSync(
        account: Account?,
        extras: Bundle?,
        authority: String?,
        provider: ContentProviderClient?,
        syncResult: SyncResult?
    ) {
        try {
            val playerIds = playersStore.all.map { p -> p.id }.toMutableList()
            val teamIds = teamsStore.all.map { t -> t.id }.toMutableList()
            runBlocking(Dispatchers.IO) {
                flow {
                    var page = 0
                    var totalCnt: Long
                    do {
                        repository.getPlayers(page, READ_COUNT).let { result ->
                            if (result.isSuccess) {
                                result.getOrNull()?.let { playerData ->
                                    totalCnt = playerData.meta.totalCount?.toLong() ?: 0L
                                    syncResult?.let { sr ->
                                        sr.stats.numEntries = totalCnt
                                        playerData.players.forEachIndexed { idx, player ->
                                            emit(player)
                                            playerData.meta.perPage?.let { pp ->
                                                sr.stats.numInserts = (idx + (page * (pp))).toLong()
                                            }
                                        }
                                    }
                                    page = playerData.meta.nextPage ?: -1
                                }
                            }
                        }
                    } while (page > 0)
                }.collect { player ->
                    if (playerIds.containsNot { id -> id == player.id }) {
                        playersStore.put(player)
                        playerIds.add(player.id)
                        Timber.d("Player: $player stored.")
                    } else {
                        // todo ? check changed
                    }
                    val team = player.team
                    if (teamIds.containsNot { id -> id == team.id }) {
                        teamsStore.put(team)
                        teamIds.add(team.id)
                        Timber.d("Team: $team stored.")
                    } else {
                        // todo ? check changed
                    }
                }
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

}