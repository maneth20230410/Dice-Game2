package com.example.dicegame2.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dicegame2.logic.GameState
import com.example.dicegame2.logic.rollDice
import com.example.dicegame2.ui.theme.util.ButtonBar
import com.example.dicegame2.ui.theme.util.ScoreSection
import com.example.dicegame2.ui.theme.util.getDiceImage
import androidx.compose.runtime.saveable.rememberSaveable


@Composable
fun GameScreen(onBackPress: () -> Unit) {
    var gameState by rememberSaveable { mutableStateOf(GameState()) }
    val context = LocalContext.current

    fun startNewGame() {
        gameState = GameState()  // Reset game state
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Scoreboard Section - Aligning Left & Right
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ScoreSection(
                title = "Overall Score",
                playerScore = gameState.playerOverallScore,
                computerScore = gameState.computerOverallScore,
                alignment = Alignment.Start, // Left-aligned
                modifier = Modifier.weight(1f)
            )

            ScoreSection(
                title = "Game Score",
                playerScore = gameState.playerGameScore,
                computerScore = gameState.computerGameScore,
                alignment = Alignment.End, // Right-aligned
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Computer Dice Row
        Text("Computer", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(Alignment.CenterHorizontally))
        LazyRow (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            items(gameState.computerDice) { dice ->
                Image(
                    painter = getDiceImage(dice),
                    contentDescription = "Computer Dice",
                    modifier = Modifier.size(60.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Player Dice Row
        Text("Player", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.align(Alignment.CenterHorizontally))
        LazyRow (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            items(gameState.playerDice) { dice ->
                Image(
                    painter = getDiceImage(dice),
                    contentDescription = "Player Dice",
                    modifier = Modifier.size(60.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Buttons
        ButtonBar(
            onThrow = {
                if (gameState.rollsLeft > 0) {
                    val newPlayerDice = rollDice(5)
                    val newComputerDice = rollDice(5)

                    gameState = gameState.copy(
                        playerDice = newPlayerDice,
                        computerDice = newComputerDice,
                        playerGameScore = newPlayerDice.sum(),
                        computerGameScore = newComputerDice.sum(),
                        rollsLeft = gameState.rollsLeft - 1
                    )
                }
            },
            onScore = {
                gameState = gameState.copy(
                    playerOverallScore = gameState.playerOverallScore + gameState.playerGameScore,
                    computerOverallScore = gameState.computerOverallScore + gameState.computerGameScore,
                    gameOver = gameState.rollsLeft == 0
                )

                if (gameState.gameOver) {
                    Toast.makeText(context, "Game Over: ${gameState.playerOverallScore} - ${gameState.computerOverallScore}", Toast.LENGTH_LONG).show()
                }
            },
            onNewGame = { startNewGame() }
        )
    }
}
