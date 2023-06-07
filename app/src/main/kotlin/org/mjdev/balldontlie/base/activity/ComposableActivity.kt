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
import org.mjdev.balldontlie.base.helpers.Ext.NavHostEx
import org.mjdev.balldontlie.base.navigation.NavGraphBuilderEx
import org.mjdev.balldontlie.ui.theme.BallDontLieTheme
import timber.log.Timber

/**
 * Composable activity.
 *
 * Activity that holds all the logic for navigation, to simplify it.
 * See usage in [org.mjdev.balldontlie.activity.MainActivity]
 *
 * @constructor Create [ComposableActivity]
 * @property navGraphBuilder
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class ComposableActivity(
    val navGraphBuilder: NavGraphBuilderEx.() -> Unit
) : ComponentActivity() {

    /**
     * Custom activity result listeners
     */
    val activityResultListeners = mutableListOf<ActivityResultHandler<*>>()

    /**
     * {@inheritDoc}
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BallDontLieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHostEx(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,
                        builder = navGraphBuilder
                    )

                }
            }
        }

    }

    /**
     * On activity result handler.
     *
     * @param requestCode Request code
     * @param resultCode Result code
     * @param intent Intent
     */
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

    /**
     * Register for activity result.
     *
     * Custom handler registration.
     *
     * @param onLaunch On launch method, to start custom activity.
     * @param onActivityResult On activity result handler.
     * @param T T result type
     * @return [ActivityResultHandler] handler generated
     */
    fun <T> registerForActivityResult(
        onLaunch: (args: List<T>) -> Unit,
        onActivityResult: (requestCode: Int, resultCode: Int, intent: Intent?) -> Unit
    ): ActivityResultHandler<T> = ActivityResultHandler(
        lifecycle,
        onLaunch,
        onActivityResult
    )

    /**
     * Activity result handler.
     *
     * @param I
     * @constructor Create [ActivityResultHandler]
     * @property lifecycle lifecycle handler
     * @property onLaunch function to start activity
     * @property onActivityResult result handler
     */
    @Suppress("unused")
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

        /**
         * Function to register result handler.
         * It is called automatically upon lifecycle state.
         * */
        fun unregister() {
            lifecycle.removeObserver(observer)
            activityResultListeners.remove(this)
        }

        /**
         * Post result to handler.
         *
         * @param requestCode Request code
         * @param resultCode Result code
         * @param intent Intent result data
         */
        fun postResult(requestCode: Int, resultCode: Int, intent: Intent?) {
            onActivityResult(requestCode, resultCode, intent)
        }

        /**
         * Launch the onLaunch handler.
         *
         * @param args Args
         */
        fun launch(vararg args: I) {
            onLaunch(args.toList())
        }

    }

}