package org.mjdev.balldontlie.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import org.mjdev.balldontlie.base.helpers.Ext.asMutableFlow
import org.mjdev.balldontlie.base.viewmodel.BaseViewModel
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: IRepository
) : BaseViewModel() {

    private val isMock = repository is MockedRepository

    suspend fun players(
        page: Int = 0,
        cnt: Int = 50
    ): Flow<List<Player>> = runSafe {
//        if (isMock) {
           (repository as MockedRepository).players().players.asMutableFlow()
//        } else {
//            repository.getPlayers(page, cnt).getOrThrow().map { data ->
//                data.players
//            }
//        }
    }

}