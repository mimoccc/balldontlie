package org.mjdev.moneta.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import org.mjdev.moneta.base.helpers.ListPagingSource.Companion.pagerList
import org.mjdev.moneta.repository.ApiRepository
import org.mjdev.moneta.base.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val repository: ApiRepository
) : BaseViewModel() {

    @Suppress("PrivatePropertyName")
    private val DEFAULT_COUNT_OF_PLAYERS = 25L

    fun players() = pagerList(DEFAULT_COUNT_OF_PLAYERS) { p, c ->
        repository.getPlayers(p, c).getOrThrow().players
    }.cachedIn(viewModelScope)

}