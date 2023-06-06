package org.mjdev.balldontlie.base.navigation

import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavigatorProvider
import java.lang.RuntimeException

class NavGraphBuilderEx(
    provider: NavigatorProvider,
    route: String?,
    val navHostController: NavHostController
) : NavGraphBuilder(provider, "none", route) {

    var startDestinationRouteEx: String? = null

    var menuItems: MutableList<MenuItem> = mutableListOf()

    override fun build(): NavGraph {
        val navGraph = super.build()
        if (startDestinationRouteEx == null) {
            throw(RuntimeException("One class in ComposeActivity should have start property set."))
        }
        navGraph.setStartDestination(startDestinationRouteEx!!)
        return navGraph
    }

}