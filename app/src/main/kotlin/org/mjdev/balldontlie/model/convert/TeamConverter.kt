package org.mjdev.balldontlie.model.convert

import io.objectbox.kotlin.boxFor
import org.mjdev.balldontlie.model.MyObjectBox
import org.mjdev.balldontlie.model.Team

class TeamConverter(
    supplier: (id: Long) -> Team? = { id ->
        MyObjectBox.builder().build().boxFor<Team>().get(id)
    }
) : CustomPropertyConverter<Team>(supplier)