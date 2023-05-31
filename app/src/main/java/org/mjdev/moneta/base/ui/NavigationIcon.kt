package org.mjdev.moneta.base.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun NavigationIcon(
    navigationIcon: ImageVector = Icons.Filled.Menu,
    onNavigationIconClick: () -> Unit = {},
) {
    IconButton(
        onClick = onNavigationIconClick
    ) {
        Icon(
            imageVector = navigationIcon,
            contentDescription = ""
        )
    }
}