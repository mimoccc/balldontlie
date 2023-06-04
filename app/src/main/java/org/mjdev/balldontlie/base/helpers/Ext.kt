package org.mjdev.balldontlie.base.helpers

import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavigatorProvider
import androidx.navigation.compose.composable
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.mjdev.balldontlie.BuildConfig
import org.mjdev.balldontlie.base.navigation.NavGraphBuilderEx
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.repository.IRepository
import org.mjdev.balldontlie.repository.MockedRepository.Companion.MockRepository
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.jvmErasure

@Suppress("unused")
object Ext {

    @Composable
    fun <T> runInComposeScope(function: suspend () -> T): MutableState<T?> {
        val composableScope = rememberCoroutineScope()
        val result = remember { mutableStateOf<T?>(null) }
        LaunchedEffect(key1 = Unit) {
            withContext(composableScope.coroutineContext) {
                result.value = function.invoke()
            }
        }
        return result
    }

    fun Drawable.asImageBitmap(width: Int = 1, height: Int = 1): ImageBitmap =
        toBitmap(width, height).asImageBitmap()

    @Composable
    fun <T> previewData(
        block: () -> T
    ): T? = if (isEditMode()) block.invoke() else null

    @Composable
    fun <T> previewData(
        defaultValue: T,
        block: () -> T
    ): T = if (isEditMode()) block.invoke() else defaultValue

    @Composable
    fun <T : Any> previewLazyData(vararg values: T) =
        flowOf(PagingData.from(values.toList())).collectAsLazyPagingItems()

    @Composable
    inline fun <reified T> textFrom(text: T?): String? = when (text) {
        is Int -> LocalContext.current.getString(text)
        is String -> text
        else -> null
    }

    fun fromHtml(html: String?): Spanned {
        return when {
            html == null -> {
                SpannableString("")
            }

            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
            }

            else -> {
                @Suppress("DEPRECATION")
                Html.fromHtml(html)
            }
        }
    }

    val NavHostController.currentRoute get() = currentDestination?.route

    @Composable
    fun stringResWithStyling(@StringRes id: Int?): String? = LocalContext.current.resources
        .let { res ->
            id?.let { id -> res.getText(id) }
        }?.toString()

    @Composable
    fun NavHost(
        modifier: Modifier = Modifier,
        route: String? = null,
        navController: NavHostController,
        builder: NavGraphBuilderEx.() -> Unit
    ) {
        androidx.navigation.compose.NavHost(
            navController,
            remember(route, builder) {
                navController.createGraph(
                    route,
                    navController,
                    builder
                )
            },
            modifier
        )
    }

    private inline fun NavController.createGraph(
        route: String? = null,
        navController: NavHostController,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = navigatorProvider.navigation(navController, route, builder)

    private inline fun NavigatorProvider.navigation(
        navController: NavHostController,
        route: String? = null,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = NavGraphBuilderEx(this, route, navController)
        .apply(builder)
        .build()

    fun <T : Screen> NavGraphBuilderEx.screen(route: T) {
        if (route.isStartDestination) {
            startDestinationRouteEx = route.completeRoute
        }
        route.menuItem?.also { menuItem ->
            menuItems.add(menuItem)
        }
        composable(
            route = route.completeRoute,
            arguments = route.args
        ) { be ->
            route.Compose(navHostController, be, menuItems)
        }
    }

    @Composable
    fun isEditMode() = LocalInspectionMode.current

    @Composable
    fun isMock() = BuildConfig.USE_MOCK || isEditMode()

    @Composable
    inline fun <reified VM : ViewModel> appViewModel(
        viewModelStoreOwner: ViewModelStoreOwner? = null,
        crossinline initBlock: VM.() -> Unit = {}
    ): VM = if (isMock() || isEditMode()) {
        mockViewModel<VM>().apply(initBlock)
    } else {
        val viewModelStoreOwnerImpl =
            viewModelStoreOwner ?: checkNotNull(LocalViewModelStoreOwner.current) {
                "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
            }
        viewModel(
            viewModelStoreOwner = viewModelStoreOwnerImpl,
            factory = createHiltViewModelFactory(viewModelStoreOwnerImpl)
        )
    }.apply(initBlock)

    @Composable
    fun <T : R, R> Flow<T>.collectAsState(
        initial: R,
        context: CoroutineContext = EmptyCoroutineContext
    ): State<R> {
        return if (isEditMode()) {
            // todo remove blocking
            runBlocking(context) {
                var ret: R = initial
                collect { value ->
                    ret = value
                }
                mutableStateOf(ret)
            }
        } else {
            produceState(initial, this, context) {
                if (context == EmptyCoroutineContext) {
                    collect { value = it }
                } else withContext(context) {
                    collect { value = it }
                }
            }
        }
    }

    @Composable
    inline fun <reified VM> mockViewModel(): VM {
        val mockConstructor = VM::class.constructors.first { c ->
            c.parameters.size == 1 &&
                    c.parameters[0].type.jvmErasure.isSubclassOf(IRepository::class)
        }
        return mockConstructor.call(MockRepository)
    }

    @Composable
    @PublishedApi
    internal fun createHiltViewModelFactory(
        viewModelStoreOwner: ViewModelStoreOwner
    ): ViewModelProvider.Factory? = if (viewModelStoreOwner is NavBackStackEntry) {
        HiltViewModelFactory(
            context = LocalContext.current,
            navBackStackEntry = viewModelStoreOwner
        )
    } else {
        null
    }

    fun NavBackStackEntry.arg(
        argId: String,
        defaultValue: Int
    ): Int? = arguments?.getInt(argId, defaultValue)

}