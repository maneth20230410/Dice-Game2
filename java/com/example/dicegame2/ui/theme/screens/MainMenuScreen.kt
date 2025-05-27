package com.example.dicegame2.ui.theme.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dicegame2.GameActivity // Ensure you import GameActivity

@Composable
fun MainMenuScreen(onStartGame: () -> Unit, onExitGame: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DICE GAME",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 32.dp) // Add top padding
        )

        Spacer(modifier = Modifier.height(100.dp)) // Add space

        // New Game Button (Start Game Activity using Intent)
        Button(onClick = { onStartGame() }) {
            Text("New Game")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // About Button (Toggles the Dialog)
        Button(onClick = { showDialog = true }) {
            Text("About")
        }

        // Show About Dialog when `showDialog` is true
        if (showDialog) {
            AboutDialog(onDismiss = { showDialog = false })
        }
    }
}

// About Dialog
@Composable
fun AboutDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("About the Game") },
        text = {
            Text("Author: Maneth Wijewardana \nStudent ID: w2083122/20230410\n\nI confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.")
        },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("OK")
            }
        }
    )
}
