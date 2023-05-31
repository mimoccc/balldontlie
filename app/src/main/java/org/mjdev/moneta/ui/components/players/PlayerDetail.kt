package org.mjdev.moneta.ui.components.players

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mjdev.moneta.mock.Mock
import org.mjdev.moneta.model.Player

@Preview(showBackground = true)
@Composable
fun PlayerDetail(
    modifier: Modifier = Modifier,
    playerData: Player? = Mock.player(1),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    circleImageColor: Color = MaterialTheme.colorScheme.tertiary,
    circleBorderColor: Color = Color.Black
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            PlayerListItem(
                item = playerData,
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            ),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("id : ${playerData?.id ?: ""}")
                Text("firstName : ${playerData?.firstName ?: ""}")
                Text("lastName : ${playerData?.lastName ?: ""}")
                Text("position : ${playerData?.position ?: ""}")
                Text("heightInches : ${playerData?.heightInches ?: ""}")
                Text("pounds : ${playerData?.weightPounds ?: ""}")
                Text("heightFeet : ${playerData?.heightFeet ?: ""}")
                Text("team id : ${playerData?.team?.id ?: ""}")
                Text("team name : ${playerData?.team?.name ?: ""}")
                Text("team full name : ${playerData?.team?.fullName ?: ""}")
                Text("team city : ${playerData?.team?.city ?: ""}")
                Text("team abbreviation : ${playerData?.team?.abbreviation ?: ""}")
                Text("team conference : ${playerData?.team?.conference ?: ""}")
                Text("team division : ${playerData?.team?.division ?: ""}")
                Text("team abbreviation : ${playerData?.team?.abbreviation ?: ""}")
            }
        }
    }

}