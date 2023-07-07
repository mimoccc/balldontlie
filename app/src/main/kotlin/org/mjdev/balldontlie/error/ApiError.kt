package org.mjdev.balldontlie.error

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import retrofit2.Response
import java.net.UnknownHostException

@Parcelize
open class ApiError(
    override val message: String = "Unknown error.",
    open val title: String = "Error",
    open val t: Throwable? = null
) : Exception(message, t), Parcelable {

    @IgnoredOnParcel
    open var textColor: Color = Color.White

    @IgnoredOnParcel
    open var backgroundColor = Color.Red

    constructor(
        response: Response<*>
    ) : this(createMessage(response))

    constructor(e: Throwable) : this(message = createMessage(e), t = e)

    val lineNumber: Int get() = cause?.stackTrace?.first()?.lineNumber ?: -1

    @Suppress("LeakingThis")
    @IgnoredOnParcel
    val fileName : String = cause?.stackTrace?.first()?.fileName ?: "-"

    companion object {

        fun Throwable.asApiError(): ApiError = ApiError(this)

        private fun createMessage(response: Response<*>): String {
            return when (val httpError = HttpError(response.code())) {
                HttpError.Unknown -> "Error response from network. Error:${response.errorBody()}."
                else -> "${httpError.code} : ${httpError.message}"
            }
        }

        // todo handle more errors
        private fun createMessage(e: Throwable): String {
            return when (e) {
                is UnknownHostException -> "Internet or connection error."
                else -> e.message ?: "Unknown error."
            }
        }

    }

}