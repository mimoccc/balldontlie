package org.mjdev.balldontlie.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mjdev.balldontlie.base.viewmodel.BaseViewModel
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val repository: IRepository,
) : BaseViewModel() {

    private val isMock = repository is MockedRepository

    suspend fun player(playerId: Int): Player = runSafe {
        if (isMock) {
            (repository as MockedRepository).player(playerId.toLong())
        } else {
            repository.getPlayer(playerId).getOrThrow()
        }
    }

}