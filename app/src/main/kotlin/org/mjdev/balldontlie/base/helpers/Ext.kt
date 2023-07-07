package org.mjdev.balldontlie.base.helpers

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.mjdev.balldontlie.BuildConfig
import org.mjdev.balldontlie.base.navigation.NavGraphBuilderEx
import org.mjdev.balldontlie.base.navigation.Screen
import org.mjdev.balldontlie.repository.def.IRepository
import org.mjdev.balldontlie.repository.impl.MockedRepository.Companion.MockRepository
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.jvm.jvmErasure

@Suppress("unused")
object Ext {

    /**
     * Launch coroutine.
     *
     * Function extends base framework functionality to call function or method
     * in coroutine scope
     *
     * @param block code to be run in coroutine
     */
    @Composable
    fun LaunchCoroutine(block: suspend () -> Unit) {
        val coroutineScope = rememberCoroutineScope()
        LaunchedEffect(coroutineScope) {
            block.invoke()
        }
    }

    /**
     * Contains for list.
     *
     * Function check existence of multiple or one item in list due function
     * call.
     *
     * Preferably used to check existence of array of items in list.
     *
     * @param prediction validation prediction
     * @param T T type of result value
     * @return
     * @receiver
     */
    fun <T> List<T>.contains(prediction: (T) -> Boolean) =
        count(prediction) > 0

    /**
     * Contains not for list.
     *
     * Function check non existence of multiple or one item in list due
     * function call.
     *
     * Preferably used to check non existence of array of items in list.
     *
     * @param prediction validation prediction
     * @param T T
     * @return
     * @receiver
     */
    fun <T> List<T>.containsNot(prediction: (T) -> Boolean) =
        count(prediction) == 0

    /**
     * Function converts drawable to an [ImageBitmap] object used in compose
     * painters.
     *
     * @param width Width width requested
     * @param height Height height requested
     * @return [ImageBitmap] function result
     * @receiver [Drawable] drawable to convert from
     */
    fun Drawable.asImageBitmap(
        width: Int,
        height: Int
    ): ImageBitmap = toBitmap(width, height).asImageBitmap()

    /**
     * Preview data. Helper function for previews in edit mode. It runs
     * function in block and return is given to a composable function. Or it
     * returns null if in released app.
     *
     * @param block code to get result from
     * @param T T type of result
     * @return [T] result or null
     */
    @Composable
    fun <T> previewData(
        block: () -> T
    ): T? = if (isEditMode()) block.invoke() else null

    /**
     * Preview data. Helper function for previews in edit mode. It runs
     * function in block and return is given to a composable function. Or it
     * returns [defaultValue] if in released app.
     *
     * @param defaultValue Default value
     * @param block code to get result from
     * @param T T type of result
     * @return [T] result or [defaultValue]
     */
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
    inline fun <reified T : Any> previewSource(count: Int): SOURCE<T> = if (isEditMode()) { _, _ ->
        mutableListOf<T>().apply {
            (1..count).map {
                T::class.constructors.first { it.parameters.isEmpty() }.call()
            }.also { item ->
                add(item as T)
            }
        }
    } else { _, _ -> emptyList() }

    /**
     * Helper function to return text from any object is given as input.
     * Mainly: Int -> is represented as resource text id String -> String null
     * -> empty string other -> toString() call result
     *
     * @param text Text
     * @param T T type of result
     * @return String generated from any resource given
     */
    @Composable
    inline fun <reified T> textFrom(text: T?): String = when (text) {
        null -> ""
        is Unit -> ""
        is Int -> LocalContext.current.getString(text)
        is String -> text
        else -> text.toString()
    }

    /**
     * Non composable stringResource version.
     *
     * @param id Id
     * @return String generated from resource given
     * @receiver [Context]
     */
    fun Context.stringResource(
        @StringRes id: Int
    ): String = resources.getString(id)

    /**
     * Function made calls until retry count is not 0. As a result it give
     * block call result or Unit, if retry count is 0.
     *
     * @param retryDelay Retry delay
     * @param maxRetryCount Max retry count
     * @param condition Condition
     * @param block code that is run [maxRetryCount] times, delayed
     *     [retryDelay] ms, until condition reached true.
     * @param T T return value
     * @return [T]
     */
    suspend fun <T> retrySuspend(
        retryDelay: Long = ListPagingSource.DEFAULT_RETRY_DELAY,
        maxRetryCount: Int = ListPagingSource.DEFAULT_MAX_RETRY_COUNT,
        condition: T.() -> Boolean,
        block: suspend () -> T
    ): T {
        var retryCount = maxRetryCount
        var ret = block.invoke()
        while ((!condition.invoke(ret)) && (retryCount > 0)) {
            delay(retryDelay)
            ret = block.invoke()
            retryCount -= 1
        }
        return ret
    }

    /**
     * Helper function to made spannable html text. To use html in code, and
     * render it to user.
     *
     * @param html Html html string
     * @return [Spanned] html in spannable class
     */
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

    /**
     * Current route nav host helper
     *
     * Function returns current route that is shown.
     *
     * @return current route on screen
     */
    val NavHostController.currentRoute
        get() =
            currentDestination?.route

    /**
     * Return the string value associated with a particular resource ID. The
     * returned object will be a String if this is a plain string; it will be
     * some other type of CharSequence if it is styled. {@more}
     *
     * @param id The desired resource identifier, as generated by the aapt
     *     tool. This integer encodes the package, type, and resource entry.
     *     The value 0 is an invalid identifier.
     * @return CharSequence The string data associated with the resource, plus
     *     possibly styled text information.
     */
    @Composable
    fun stringResWithStyling(
        @StringRes id: Int?
    ): String? = LocalContext.current.resources.let { res ->
        id?.let { id -> res.getText(id) }
    }?.toString()

    /**
     * Custom NavHost object to extend functionality and simplify
     * navigation across application.
     *
     * @param modifier Modifier modifier as usual for composable
     * @param route Route route expected
     * @param navController Nav controller navigation controller
     * @param builder Builder builder for routes
     */
    @Composable
    fun NavHostEx(
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

    /**
     * Create navigation graph from nav controller.
     * Extended just with custom builder.
     *
     * @see: [androidx.navigation.NavController.createGraph]
     *
     * @param route Route
     * @param navController Nav controller
     * @param builder Builder
     * @return [NavGraph]
     * @receiver [NavController]
     */
    private inline fun NavController.createGraph(
        route: String? = null,
        navController: NavHostController,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = navigatorProvider.navigation(navController, route, builder)

    /**
     * Create navigation from extra builder to simplify generation of routes.
     * @see: [androidx.navigation.NavigatorProvider.navigation]
     *
     * @param navController Nav controller
     * @param route Route
     * @param builder Builder
     * @return [NavGraph]
     * @receiver [NavigatorProvider]
     */
    private inline fun NavigatorProvider.navigation(
        navController: NavHostController,
        route: String? = null,
        builder: NavGraphBuilderEx.() -> Unit
    ): NavGraph = NavGraphBuilderEx(this, route, navController)
        .apply(builder)
        .build()

    /**
     * Custom function to generate screen in nav graph.
     *
     * @param route Route route expected
     * @param isHomeScreen Is home screen, indicates that this screen will
     * be used as home screen. Should be used once, or in case that is defined multiple times,
     * the last one is used as home screen.
     *
     * @param T T Screen object generated for route.
     * @receiver [NavGraphBuilderEx]
     */
    fun <T : Screen> NavGraphBuilderEx.screen(
        route: T,
        isHomeScreen: Boolean = false
    ) {
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

    /**
     * Is edit mode.
     *
     * Indicator function, hat screen or component is in rendering preview mode.
     *
     * @return true if we are in compose compose mode.
     */
    @Composable
    fun isEditMode() =
        LocalInspectionMode.current

    /**
     * Is mock.
     *
     * Indicates custom mock mode.
     * Mode used for preview of an application without real data.
     *
     * @return
     */
    @Composable
    fun isMock() =
        BuildConfig.USE_MOCK || isEditMode()

    /**
     * Extended functionality to avoid generation of view model with lifecycle which
     * is not supported yet in compose preview.
     *
     * Function generates mocked view model, which should call [isMock] function
     * and generate simplified mocked result for caller.
     *
     * @param viewModelStoreOwner View model store owner
     * @param initBlock Init block
     * @param VM Vm
     * @return [VM]
     */
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

    /**
     * Function collects data from flow to an state value.
     * This function is only extended for edit mode, as preview does not call
     * suspended functions when in preview.
     *
     * @param initial Initial
     * @param context Context
     * @param T T
     * @param R R
     * @return [State]
     * @receiver [Flow]
     */
    @Composable
    fun <T : R, R> Flow<T>.collectAsState(
        initial: R,
        context: CoroutineContext = EmptyCoroutineContext
    ): State<R> {
        return if (isEditMode()) {
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

    /**
     * Mock view model generation function.
     *
     * In this case is used reflection, as there are no another possibility.
     *
     * Function generate mocked view model, mainly with [MockRepository] as a input.
     *
     * @param VM Vm
     * @return [VM]
     */
    @Composable
    inline fun <reified VM> mockViewModel(
        repository:IRepository = MockRepository
    ): VM {
        val mockConstructor = VM::class.constructors.first { c ->
            c.parameters.size == 1 &&
                    c.parameters[0].type.jvmErasure.isSubclassOf(IRepository::class)
        }
        return mockConstructor.call(repository)
    }

    /**
     * Create hilt view model factory.
     *
     * @param viewModelStoreOwner View model store owner
     * @return [ViewModelProvider.Factory] or null
     */
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

    /**
     * Helper function to get params from route.
     *
     * @param argId Arg id
     * @param defaultValue Default value
     * @return
     * @receiver [NavBackStackEntry]
     */
    fun NavBackStackEntry.arg(
        argId: String,
        defaultValue: Int
    ): Int? = arguments?.getInt(argId, defaultValue)

}