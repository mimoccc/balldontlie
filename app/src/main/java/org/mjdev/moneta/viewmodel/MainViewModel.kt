package org.mjdev.moneta.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.mjdev.moneta.base.helpers.ListPagingSource.Companion.pagerList
import org.mjdev.moneta.base.viewmodel.BaseViewModel
import org.mjdev.moneta.repository.IRepository
import org.mjdev.moneta.repository.MockedRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: IRepository
) : BaseViewModel() {

    @Suppress("PrivatePropertyName")
    private val DEFAULT_COUNT_OF_PLAYERS = 25

    private val isMock = repository is MockedRepository

    fun players() = runSafe {
        if (isMock) {
            MutableStateFlow(PagingData.from((repository as MockedRepository).players().players))
        } else {
            pagerList(DEFAULT_COUNT_OF_PLAYERS) { page, count ->
                repository.getPlayers(page, count).getOrThrow().players
            }.cachedIn(viewModelScope)
        }
    }

}