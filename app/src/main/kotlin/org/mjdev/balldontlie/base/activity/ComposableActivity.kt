@file:Suppress("DEPRECATION")

package org.mjdev.balldontlie.base.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.compose.rememberNavController
import org.mjdev.balldontlie.base.helpers.Ext.NavHost
import org.mjdev.balldontlie.base.navigation.NavGraphBuilderEx
import org.mjdev.balldontlie.ui.theme.BallDontLieTheme
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate")
abstract class ComposableActivity(
    val navGraphBuilder: NavGraphBuilderEx.() -> Unit
) : ComponentActivity() {

    val activityResultListeners = mutableListOf<ActivityResultHandler<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BallDontLieTheme {
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

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        activityResultListeners.forEach { listener ->
            try {
                listener.postResult(requestCode, resultCode, intent)
            } catch (e: Throwable) {
                Timber.e(e)
            }
        }
    }

    fun <T> registerForActivityResult(
        onLaunch: (args: List<T>) -> Unit,
        onActivityResult: (requestCode: Int, resultCode: Int, intent: Intent?) -> Unit
    ): ActivityResultHandler<T> = ActivityResultHandler(
        lifecycle,
        onLaunch,
        onActivityResult
    )

    inner class ActivityResultHandler<I>(
        val lifecycle: Lifecycle,
        val onLaunch: (args: List<I>) -> Unit,
        val onActivityResult: (requestCode: Int, resultCode: Int, intent: Intent?) -> Unit,
    ) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_DESTROY -> {
                    unregister()
                }

                else -> {}
            }
        }

        init {
            lifecycle.addObserver(observer)
            activityResultListeners.add(this)
        }

        fun unregister() {
            lifecycle.removeObserver(observer)
            activityResultListeners.remove(this)
        }

        fun postResult(requestCode: Int, resultCode: Int, intent: Intent?) {
            onActivityResult(requestCode, resultCode, intent)
        }

        fun launch(vararg args: I) {
            onLaunch(args.toList())
        }

    }

}