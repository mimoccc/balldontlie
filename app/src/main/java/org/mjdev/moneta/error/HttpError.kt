package org.mjdev.moneta.error

enum class HttpError(val code: Int, val message: String) {
    Unknown(
            -1,
            "Unknown error."
    ),
    Http400(
        400,
        "Bad Request. Your request is invalid."
    ),
    Http404(
        404,
        "Not Found. The specified resource could not be found."
    ),
    Http406(
        406,
        "Not Acceptable. You requested a format that isn't json."
    ),
    Http429(
        429,
        "Too Many Requests. Stop bombarding us."
    ),
    Http500(
        500,
        "Internal Server Error. We had a problem with our server. Try again later."
    ),
    Http503(
        503,
        "Service Unavailable. We're temporarily offline for maintenance. Please try again later."
    );

    companion object {

        operator fun invoke(code: Int) =
            values().firstOrNull { it.code == code } ?: Unknown

    }

}