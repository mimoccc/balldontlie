package org.mjdev.balldontlie.error

import androidx.compose.ui.graphics.Color

@Suppress("unused")
class Info : ApiError {

    constructor(message: String) : super(message)

    constructor(e: Throwable) : super(e)

    override var textColor: Color = Color.White
    override var backgroundColor = Color.Green

}