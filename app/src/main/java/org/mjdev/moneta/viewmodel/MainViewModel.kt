package org.mjdev.moneta.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import org.mjdev.moneta.base.helpers.ListPagingSource.Companion.pagerList
import org.mjdev.moneta.repository.ApiRepository
import org.mjdev.moneta.base.viewmodel.BaseViewModel
import org.mjdev.moneta.base.viewmodel.ViewModelError
import org.mjdev.moneta.mock.Mock
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: ApiRepository?,
    var isMock: Boolean
) : BaseViewModel() {

    @Suppress("PrivatePropertyName")
    private val DEFAULT_COUNT_OF_PLAYERS = 25L

    @Suppress("unused")
    constructor() : this(null, true)

    fun players() = runSafe {
        pagerList(DEFAULT_COUNT_OF_PLAYERS) { page, count ->
            if (isMock) {
                Mock.players(page, count)
            } else {
                repository?.getPlayers(page, count)?.getOrThrow()?.players
                    ?: throw (ViewModelError("Repository not initialized"))
            }
        }.cachedIn(viewModelScope)
    }

}