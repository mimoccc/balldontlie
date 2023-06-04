package org.mjdev.balldontlie.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import org.mjdev.balldontlie.error.ApiError
import org.mjdev.balldontlie.error.EmptyError
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

    val error: MutableStateFlow<ApiError> = MutableStateFlow(EmptyError())
    private var errorHandler: (error: Throwable) -> Unit = {}

    init {
        error.onEach { error ->
            errorHandler.invoke(error)
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun onError(e: Throwable) {
        Timber.e(e)
        when (e) {
            is ApiError -> error.tryEmit(e)
            else -> error.tryEmit(ApiError(e))
        }
    }

    protected fun <T> runSafeFlow(block: suspend () -> T) = flow {
        try {
            emit(block.invoke())
        } catch (t: Throwable) {
            onError(t)
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