package org.mjdev.balldontlie.ui.components.players

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.repository.MockedRepository.Companion.MockRepository

@SuppressLint("ModifierParameter")
@DayPreview
@Composable
fun PlayerDetail(
    modifier: Modifier = previewData(Modifier) { Modifier.fillMaxSize() },
    player: Player? = previewData { MockRepository.player() }
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            PlayerListItem(
                item = player,
                showInCard = false
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text("id : ${player?.id ?: "-"}")
            Text("firstName : ${player?.firstName ?: "-"}")
            Text("lastName : ${player?.lastName ?: "-"}")
            Text("position : ${player?.position ?: "-"}")
            Text("heightInches : ${player?.heightInches ?: "-"}")
            Text("pounds : ${player?.weightPounds ?: "-"}")
            Text("heightFeet : ${player?.heightFeet ?: "-"}")
            Text("team id : ${player?.team?.id ?: "-"}")
            Text("team name : ${player?.team?.name ?: "-"}")
            Text("team full name : ${player?.team?.fullName ?: "-"}")
            Text("team city : ${player?.team?.city ?: "-"}")
            Text("team abbreviation : ${player?.team?.abbreviation ?: "-"}")
            Text("team conference : ${player?.team?.conference ?: "-"}")
            Text("team division : ${player?.team?.division ?: "-"}")
            Text("team abbreviation : ${player?.team?.abbreviation ?: "-"}")
        }
    }
}