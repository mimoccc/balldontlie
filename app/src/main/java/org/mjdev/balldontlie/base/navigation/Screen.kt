package org.mjdev.balldontlie.base.navigation

import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.annotations.StartDestination
import kotlin.reflect.full.createInstance

abstract class Screen {

    private val routeBase: String
        get() = this::class.simpleName ?: "-"

    val completeRoute: String
        get() = routeBase.let { rb ->
            var routeImpl = rb
            args.forEach { arg ->
                routeImpl = routeImpl.plus("${arg.name}={${arg.name}}")
            }
            routeImpl
        }

    abstract val titleResId: Int

    abstract val args: List<NamedNavArgument>

    open val menuResId: Int = -1

    open val menuIcon: ImageVector? = null

    val menuItem get() = if (menuResId >= 0) MenuItem(menuResId, menuIcon, completeRoute) else null

    val isStartDestination: Boolean
        get() {
            val startAnnotation = this::class.annotations.firstOrNull {
                it is StartDestination
            }
            return (startAnnotation != null)
        }

    @DayPreview
    @Composable
    @CallSuper
    open fun Compose() = Compose(null, null, emptyList())

    @Composable
    open fun Compose(
        navController: NavHostController?,
        backStackEntry: NavBackStackEntry?,
        menuItems: List<MenuItem>
    ) {
    }

    companion object {

        inline fun <reified T : Screen> open(
            navController: NavHostController?,
            vararg values: Any?
        ) {
            val instance = T::class.createInstance()
            instance.completeRoute.let { r ->
                var routeImpl = r
                instance.args.forEachIndexed { idx, arg ->
                    routeImpl = routeImpl.replace(
                        "{${arg.name}}",
                        (values[idx] ?: "").toString()
                    )
                }
                routeImpl
            }.also { finalRoute ->
                navController?.navigate(finalRoute)
            }
        }

    }

}