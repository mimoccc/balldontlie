package org.mjdev.balldontlie.base.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import org.mjdev.balldontlie.base.network.NetworkConnectivityService
import org.mjdev.balldontlie.base.network.NetworkConnectivityServiceImpl
import org.mjdev.balldontlie.base.network.NetworkStatus
import org.mjdev.balldontlie.error.ApiError
import org.mjdev.balldontlie.error.ApiError.Companion.asApiError
import org.mjdev.balldontlie.error.EmptyError
import timber.log.Timber

open class BaseViewModel(
    context: Context
) : ViewModel() {

    val error: MutableStateFlow<ApiError> = MutableStateFlow(EmptyError())

    private var errorHandler: (error: Throwable) -> Unit = {}

    /**
     * Network connectivity service
     */
    private val networkConnectivityService: NetworkConnectivityService by lazy {
        NetworkConnectivityServiceImpl(context)
    }

    /**
     * Network status as flow
     */
    val networkStatus: StateFlow<NetworkStatus> by lazy {
        networkConnectivityService.networkStatus.stateIn(
            initialValue = NetworkStatus.Unknown,
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000)
        )
    }

    init {
        error.onEach { error ->
            errorHandler.invoke(error)
        }
        networkStatus.onEach { netStatus ->
            if (netStatus !is NetworkStatus.Connected) {
                error.tryEmit(ApiError("No network available"))
            }
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun onError(e: Throwable) {
        Timber.e(e)
        when (e) {
            is ApiError -> error.tryEmit(e)
            else -> error.tryEmit(e.asApiError())
        }
    }

    @Suppress("UNCHECKED_CAST")
    protected suspend fun <T> runSafe(
        block: suspend () -> T
    ): T = try {
        block.invoke()
    } catch (t: Throwable) {
        onError(t)
    } as T

    fun handleError(block: (error: Throwable) -> Unit) {
        errorHandler = block
    }

}