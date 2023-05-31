package org.mjdev.moneta.base.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    @StringRes
    val menuTextResId: Int,
    val menuIcon: ImageVector?,
    var route: String
)