package org.mjdev.moneta.base.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.mjdev.moneta.base.helpers.Ext.NavHost
import org.mjdev.moneta.base.navigation.NavGraphBuilderEx
import org.mjdev.moneta.ui.theme.MonetaTheme

@Suppress("MemberVisibilityCanBePrivate")
abstract class ComposableActivity(
    val navGraphBuilder: NavGraphBuilderEx.() -> Unit
) : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MonetaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        builder = navGraphBuilder
                    )

                }
            }
        }

    }

}