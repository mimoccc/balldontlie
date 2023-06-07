package org.mjdev.balldontlie.base.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.LoadState
import org.mjdev.balldontlie.error.ApiError
import org.mjdev.balldontlie.error.EmptyError
import org.mjdev.balldontlie.error.Info

/**
 * Activity view state.
 * Used to keep states and change in activity.
 *
 * @param title
 * @param loading
 * @param error
 * @constructor Create [ActivityViewState]
 */
@Suppress("ReplaceCallWithBinaryOperator", "unused")
class ActivityViewState(
    title: Any? = null,
    loading: LoadState = LoadState.Loading,
    error: ApiError = EmptyError()
) {

    val errorState: MutableState<ApiError> = mutableStateOf(error)
    val loadingState: MutableState<LoadState> = mutableStateOf(loading)
    val titleState: MutableState<Any?> = mutableStateOf(title)

    /**
     * Clear error.
     * */
    fun clearError() {
        errorState.value = EmptyError()
    }

    /**
     * Set Error.
     *
     * @param message Message of an error
     */
    fun error(message: String) {
        errorState.value = ApiError(message)
    }

    /**
     * Set Error.
     *
     * @param e E Throwable to set error for
     */
    fun error(e: Throwable) {
        errorState.value = ApiError(e)
    }

    /**
     * Set info message.
     *
     * @param message Message
     */
    fun info(message: String) {
        errorState.value = Info(message)
    }

    /**
     * Set info from throwable.
     *
     * @param e E info throwable
     */
    fun info(e: Throwable) {
        errorState.value = Info(e)
    }

    /**
     * Set title.
     *
     * @param title Title
     */
    fun setTitle(title: Any?) {
        titleState.value = title
    }

    /**
     * Set loading state.
     *
     * @param state State an Load-state value
     * @see [LoadState]
     */
    @Suppress("MemberVisibilityCanBePrivate")
    fun setLoadingState(state: LoadState) {
        if (!state.equals(loadingState.value)) {
            loadingState.value = state
        }
    }

    /**
     * Set is loading.
     *
     * @return
     */
    fun setIsLoading() = setLoadingState(LoadState.Loading)

    /**
     * Set is not loading.
     *
     * @param endOfPaginationReached End of pagination reached
     * @return
     */
    fun setIsNotLoading(endOfPaginationReached: Boolean = true) =
        setLoadingState(LoadState.NotLoading(endOfPaginationReached))

    companion object {

        /**
         * Remember activity view state.
         *
         * Composable helper
         *
         * @param title Title
         * @param loading Loading
         * @param error Error
         * @return [ActivityViewState]
         */
        @Composable
        fun rememberActivityViewState(
            title: Any? = null,
            loading: LoadState = LoadState.Loading,
            error: ApiError = EmptyError()
        ): ActivityViewState = remember { ActivityViewState(title, loading, error) }

    }

}