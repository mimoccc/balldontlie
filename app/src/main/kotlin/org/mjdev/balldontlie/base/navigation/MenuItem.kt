package org.mjdev.balldontlie.base.navigation

/**
 * Menu item helper class.
 *
 * Normally you do not need to use this class, it is used to autogenerate menu items in
 * navigation drawer of an application.
 *
 * @constructor Create [MenuItem]
 * @property menuText
 * @property menuIcon
 * @property route
 */
data class MenuItem(

    val menuText: Any?,
    val menuIcon: Any?,
    var route: String

)