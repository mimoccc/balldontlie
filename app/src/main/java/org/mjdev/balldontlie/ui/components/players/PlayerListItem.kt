package org.mjdev.balldontlie.ui.components.players

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.mjdev.balldontlie.R
import org.mjdev.balldontlie.base.annotations.DayPreview
import org.mjdev.balldontlie.base.helpers.Ext.previewData
import org.mjdev.balldontlie.model.Player
import org.mjdev.balldontlie.base.ui.CircleImage
import org.mjdev.balldontlie.repository.impl.MockedRepository.Companion.MockRepository

@OptIn(ExperimentalMaterial3Api::class)
@DayPreview
@Composable
fun PlayerListItem(
    item: Player? = previewData { MockRepository.player() },
    showInCard: Boolean = true,
    onItemClick: (data: Player) -> Unit = { _ -> },
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        onClick = {
            item?.let { clieckedItem ->
                onItemClick(clieckedItem)
            }
        },
        colors = if (showInCard) CardDefaults.cardColors()
        else CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleImage(
                src = R.drawable.person,
                contentDescription = "",
                modifier = Modifier
                    .padding(2.dp)
                    .width(64.dp)
                    .height(64.dp),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "${item?.id ?: "-"}. ${item?.fullName}"
                )
                Text(
                    text = "${item?.team?.fullName ?: "No team"} / ${item?.position ?: ""}"
                )
                Text(
                    text = "${item?.heightInches ?: "-"} / ${item?.weightPounds ?: "-"} / ${item?.heightFeet ?: "-"}"
                )
            }
        }
    }

}