package org.mjdev.balldontlie.viewmodel

import android.content.Context
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import org.mjdev.balldontlie.base.viewmodel.BaseViewModel
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.model.Players
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext
    context: Context,
    private val repository: IRepository
) : BaseViewModel(context) {

    private val isMock = repository is MockedRepository

    suspend fun players(
        page: Int = 0,
        cnt: Int = 50
    ): List<Player> = runSafe {
        if (isMock) {
            (repository as MockedRepository).players(page, cnt).players
        } else {
            repository.getPlayers(page, cnt).getOrElse { e ->
                onError(e)
                Players()
            }.players
        }
    }

}