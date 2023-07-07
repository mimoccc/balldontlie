package org.mjdev.balldontlie.viewmodel

import android.content.Context
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import org.mjdev.balldontlie.base.viewmodel.BaseViewModel
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @ApplicationContext
    context: Context,
    private val repository: IRepository,
) : BaseViewModel(context) {

    private val isMock = repository is MockedRepository

    suspend fun player(playerId: Int): Player = runSafe {
        if (isMock) {
            (repository as MockedRepository).player(playerId)
        } else {
            repository.getPlayer(playerId).getOrThrow()
        }
    }

}