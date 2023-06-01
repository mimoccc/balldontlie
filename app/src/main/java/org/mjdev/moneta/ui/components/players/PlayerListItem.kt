package org.mjdev.moneta.ui.components.players

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.R
import org.mjdev.moneta.base.annotations.NightPreview
import org.mjdev.moneta.base.helpers.Ext.previewData
import org.mjdev.moneta.model.Player
import org.mjdev.moneta.base.ui.CircleImage
import org.mjdev.moneta.repository.MockedRepository.Companion.MockRepository

@OptIn(ExperimentalMaterial3Api::class)
@NightPreview
@Composable
fun PlayerListItem(
    idx: Int? = 0,
    item: Player? = previewData { MockRepository.player() },
    onItemClick: (data: Player?) -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    circleImageColor: Color = MaterialTheme.colorScheme.tertiary,
    circleBorderColor: Color = Color.Black
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        onClick = {
            onItemClick(item)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleImage(
                src = R.drawable.person,
                backGroundColor = circleImageColor,
                borderColor = circleBorderColor,
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
                    color = textColor,
                    text = "${item?.id ?: 0}. ${item?.fullName}"
                )
                Text(
                    color = textColor,
                    text = "${item?.team?.fullName ?: "No team"} / ${item?.position ?: ""}"
                )
                Text(
                    color = textColor,
                    text = "${item?.heightInches ?: 0} / ${item?.weightPounds ?: 0} / ${item?.heightFeet ?: 0}"
                )
            }
        }
    }
}