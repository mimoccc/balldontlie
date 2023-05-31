@file:Suppress("unused")

package org.mjdev.moneta.base.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import kotlinx.coroutines.launch
import org.mjdev.moneta.R
import org.mjdev.moneta.base.navigation.MenuItem
import org.mjdev.moneta.base.ui.ActivityViewState.Companion.rememberActivityViewState
import org.mjdev.moneta.error.ApiError
import org.mjdev.moneta.error.EmptyError
import org.mjdev.moneta.error.Info
import org.mjdev.moneta.ui.theme.grayLight

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ScreenView(
    navController: NavHostController? = null,
    navigationIconMain: ImageVector = Icons.Filled.Menu,
    navigationIconBack: ImageVector = Icons.Filled.ArrowBack,
    actions: @Composable RowScope.() -> Unit = {},
    colorBackground: Color = MaterialTheme.colorScheme.background,
    title: String = stringResource(R.string.app_name),
    menuItems: List<MenuItem> = listOf(),
    content: @Composable (
        state: ActivityViewState,
        padding: PaddingValues
    ) -> Unit = { state, padding -> }
) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val activityViewState = rememberActivityViewState(title)
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem: MutableState<MenuItem?> = remember { mutableStateOf(null) }

    val errorState = activityViewState.errorState
    val loadState = activityViewState.loadingState
    val titleState = activityViewState.titleState

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    menuItems.forEachIndexed { idx, item ->
                        NavigationDrawerItem(
                            icon = {
                                if (item.menuIcon != null) {
                                    Icon(item.menuIcon, contentDescription = null)
                                }
                            },
                            label = { Text(stringResource(item.menuTextResId)) },
                            selected = false,
                            onClick = {
                                selectedItem.value = menuItems.get(idx)
                                scope.launch {
                                    drawerState.close()
                                }
                                selectedItem.value?.route?.let { route ->
                                    navController?.navigate(route)
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            content = {
                Scaffold(
                    modifier = Modifier
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                        .background(colorBackground, RectangleShape),
                    topBar = {
                        LargeTopAppBar(
                            title = {
                                TitleBar(
                                    text = titleState.value
                                )
                            },
                            navigationIcon = {
                                NavigationIcon(
                                    navigationIcon = if (navController?.previousBackStackEntry != null) {
                                        navigationIconBack
                                    } else {
                                        navigationIconMain
                                    },
                                    onNavigationIconClick = {
                                        if (navController?.previousBackStackEntry != null) {
                                            navController.navigateUp()
                                        } else {
                                            scope.launch { drawerState.open() }
                                        }
                                    }
                                )
                            },
                            actions = actions,
                            scrollBehavior = scrollBehavior
                        )
                    },
                    content = { padding ->
                        content(activityViewState, padding)
                    }
                )
                CircleIndicatorScreen(
                    alpha = 0.5f,
                    backgroundColor = grayLight,
                    visibility = loadState.value is LoadState.Loading
                )
                ErrorIndicatorSmall(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    error = errorState.value
                )
            }
        )
    }
}

@Suppress("ReplaceCallWithBinaryOperator")
class ActivityViewState(
    title: String = "",
    loading: LoadState = LoadState.Loading,
    error: ApiError = EmptyError()
) {

    val errorState: MutableState<ApiError> = mutableStateOf(error)
    val loadingState: MutableState<LoadState> = mutableStateOf(loading)
    val titleState: MutableState<String> = mutableStateOf(title)

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
            title: String = "",
            loading: LoadState = LoadState.Loading,
            error: ApiError = EmptyError()
        ): ActivityViewState = remember { ActivityViewState(title, loading, error) }

    }

}

