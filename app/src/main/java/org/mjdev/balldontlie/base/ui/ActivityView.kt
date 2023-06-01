package org.mjdev.balldontlie.base.ui

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
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import kotlinx.coroutines.launch
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.base.navigation.MenuItem
import org.mjdev.balldontlie.base.states.ActivityViewState
import org.mjdev.balldontlie.base.states.ActivityViewState.Companion.rememberActivityViewState

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@DayPreview
@Composable
fun ScreenView(
    navController: NavHostController? = null,
    navigationIconMain: Any? = Icons.Filled.Menu,
    navigationIconBack: Any? = Icons.Filled.ArrowBack,
    actions: @Composable RowScope.() -> Unit = {},
    title: Any? = previewData { R.string.app_name },
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
                                    IconAny(src = item.menuIcon)
                                }
                            },
                            label = {
                                TextAny(text = item.menuText)
                            },
                            selected = false,
                            onClick = {
                                selectedItem.value = menuItems[idx]
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
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
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