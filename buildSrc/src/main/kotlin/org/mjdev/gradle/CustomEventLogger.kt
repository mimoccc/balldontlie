@file:Suppress("DEPRECATION")

package org.mjdev.gradle

import org.gradle.BuildAdapter
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState
import kotlin.Suppress

// todo all messages handling and remove non errors
@Suppress("deprecation")
class CustomEventLogger : BuildAdapter(), TaskExecutionListener {

    override fun beforeExecute(task: Task) {
        //println("[${task.name}]")
    }

    override fun afterExecute(task: Task, state: TaskState) {
    }

    @Deprecated(message = "Deprecated in Java", replaceWith = ReplaceWith(""))
    override fun buildFinished(result: BuildResult) {
        when (result.failure) {
            null -> println("Build completed.")
            else -> {
                (result.failure as Throwable).printStackTrace()
            }
        }
    }
}