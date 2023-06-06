package org.mjdev.balldontlie.error

import androidx.compose.ui.graphics.Color

class EmptyError : ApiError(
    "",
    ""
) {

    override var textColor: Color = Color.Transparent
    override var backgroundColor = Color.Transparent

}