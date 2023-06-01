package org.mjdev.moneta.base.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.error.EmptyError
import org.mjdev.moneta.error.Info

@Suppress("ReplaceCallWithBinaryOperator", "unused")
class ActivityViewState(
    title: Any? = null,
    loading: LoadState = LoadState.Loading,
    error: ApiError = EmptyError()
) {

    val errorState: MutableState<ApiError> = mutableStateOf(error)
    val loadingState: MutableState<LoadState> = mutableStateOf(loading)
    val titleState: MutableState<Any?> = mutableStateOf(title)

    fun clearError() {
        errorState.value = EmptyError()
    }

    fun error(message: String) {
        errorState.value = ApiError(message)
    }

    fun error(e: Throwable) {
        errorState.value = ApiError(e)
    }

    fun info(message: String) {
        errorState.value = Info(message)
    }

    fun info(e: Throwable) {
        errorState.value = Info(e)
    }

    fun setTitle(title: String) {
        titleState.value = title
    }

    fun setLoadingState(state: LoadState) {
        if (!state.equals(loadingState.value)) {
            loadingState.value = state
        }
    }

    fun setIsLoading() = setLoadingState(LoadState.Loading)

    fun setIsNotLoading(endOfPaginationReached: Boolean = true) =
        setLoadingState(LoadState.NotLoading(endOfPaginationReached))

    companion object {

        @Composable
        fun rememberActivityViewState(
            title: Any? = null,
            loading: LoadState = LoadState.Loading,
            error: ApiError = EmptyError()
        ): ActivityViewState = remember { ActivityViewState(title, loading, error) }

    }

}