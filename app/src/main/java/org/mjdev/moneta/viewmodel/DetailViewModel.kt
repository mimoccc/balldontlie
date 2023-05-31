package org.mjdev.moneta.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mjdev.moneta.repository.ApiRepository
import org.mjdev.moneta.base.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel
@Inject
constructor(
    private val repository: ApiRepository
) : BaseViewModel() {

    fun player(playerId: Int) = runSafe {
        repository.getPlayer(playerId.toLong()).getOrThrow()
    }

}