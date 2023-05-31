package org.mjdev.moneta.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import org.mjdev.moneta.repository.ApiRepository
import org.mjdev.moneta.base.viewmodel.BaseViewModel
import org.mjdev.moneta.base.viewmodel.ViewModelError
import org.mjdev.moneta.mock.Mock
import org.mjdev.moneta.model.Player
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val repository: ApiRepository?,
    var isMock: Boolean
) : BaseViewModel() {

    @Suppress("unused")
    constructor() : this(null, true)

    fun player(playerId: Int): Flow<Player?> = runSafeFlow {
        if (isMock) {
            Mock.player(playerId, "Player $playerId")
        } else {
            repository?.getPlayer(playerId.toLong())?.getOrThrow()
                ?: throw(ViewModelError("Repository not initialized"))
        }
    }

}