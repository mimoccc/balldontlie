package org.mjdev.balldontlie.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import org.mjdev.balldontlie.base.viewmodel.BaseViewModel
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.IRepository
import org.mjdev.balldontlie.repository.MockedRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val repository: IRepository,
) : BaseViewModel() {

    private val isMock = repository is MockedRepository

    fun player(playerId: Int): Flow<Player?> = runSafeFlow {
        if (isMock) {
            (repository as MockedRepository).player(playerId)
        } else {
            repository.getPlayer(playerId).getOrThrow()
        }
    }

}