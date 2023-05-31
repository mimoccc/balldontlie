package org.mjdev.moneta.base.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.error.EmptyError
import timber.log.Timber

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

    protected fun <T> runSafe(block: suspend () -> T) = flow {
        try {
            emit(block.invoke())
        } catch (t: Throwable) {
            onError(t)
        }
    }

    fun handleError(block: (error: Throwable) -> Unit) {
        errorHandler = block
    }

}