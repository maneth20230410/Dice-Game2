package com.example.dicegame2.ui.theme.util

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonBar(
    onThrow: () -> Unit,
    onScore: () -> Unit,
    onNewGame: () -> Unit  // Add this parameter for starting a new game
) {
    Row {
        Button(onClick = onThrow) {
            Text("Throw Dice")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = onScore) {
            Text("Score")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onNewGame, // Add this button for starting a new game
            colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.Gray)
        ) {
            Text("New Game")
        }
    }
}
