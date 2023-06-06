package org.mjdev.balldontlie.base.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay
import org.mjdev.balldontlie.BuildConfig
import org.mjdev.balldontlie.base.navigation.NavGraphBuilderEx
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository.Companion.MockRepository
import timber.log.Timber
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.jvmErasure

object Ext {

    @Composable
    fun LaunchCoroutine(block: suspend () -> Unit) {
        val coroutineScope = rememberCoroutineScope()
        LaunchedEffect(coroutineScope) {
            block.invoke()
        }
    }

    fun <T> List<T>.contains(block: (T) -> Boolean) = count(block) > 0

    fun <T> List<T>.containsNot(block: (T) -> Boolean) = count(block) == 0

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
    fun <T> previewSource(vararg data: T): SOURCE<T> = if (isEditMode()) { p, c ->
        if (data.size >= p + c) data.toList().subList(p, c)
        else if (data.size >= c) data.toList().take(c)
        else data.toList()
    } else { _, _ -> emptyList() }

    @Composable
    inline fun <reified T> textFrom(text: T?): String? = when (text) {
        is Int -> LocalContext.current.getString(text)
        is String -> text
        else -> null
    }

    fun Context.stringResource(@StringRes id: Int): String = resources.getString(id)

    @Throws(Exception::class)
    fun <T> retry(
        retryCnt: Int = 8,
        retryDelay: Long = 500L,
        looper: Looper = Looper.myLooper() ?: Looper.getMainLooper(),
        onError: (error: Throwable) -> Unit = { e -> throw (e) },
        block: () -> T
    ) {
        var retryStep = retryCnt
        try {
            block.invoke()
        } catch (e: Throwable) {
            Timber.e(e)
            retryStep -= 1
            if (retryStep > 0) {
                Handler(looper).postDelayed({
                    retry(retryStep, retryDelay, looper, onError, block)
                }, retryDelay)
            } else {
                onError(e)
            }
        }
    }

    suspend fun <T> retrySuspend(
        retryDelay: Long = ListPagingSource.DEFAULT_RETRY_DELAY,
        maxRetryCount: Int = ListPagingSource.DEFAULT_MAX_RETRY_COUNT,
        condition: T.() -> Boolean,
        block: suspend () -> T
    ) : T {
        var retryCount = maxRetryCount
        var ret = block.invoke()
        while ((!condition.invoke(ret)) && (retryCount > 0)) {
            delay(retryDelay)
            ret = block.invoke()
            retryCount -= 1
        }
        return ret
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

    fun <T : Screen> NavGraphBuilderEx.screen(route: T, isHomeScreen: Boolean = false) {
        if (isHomeScreen) {
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

//    @Composable
//    fun <T : R, R> Flow<T>.collectAsState(
//        initial: R,
//        context: CoroutineContext = EmptyCoroutineContext
//    ): State<R> {
//        return if (isEditMode()) {
//            runBlocking(context) {
//                var ret: R = initial
//                collect { value ->
//                    ret = value
//                }
//                mutableStateOf(ret)
//            }
//        } else {
//            produceState(initial, this, context) {
//                if (context == EmptyCoroutineContext) {
//                    collect { value = it }
//                } else withContext(context) {
//                    collect { value = it }
//                }
//            }
//        }
//    }

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