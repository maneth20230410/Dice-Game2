package com.example.dicegame2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dicegame2.ui.theme.DiceGame2Theme
import com.example.dicegame2.ui.theme.screens.MainMenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceGame2Theme {
                MainMenuScreen(
                    onStartGame = { startGame() }, // Call startGame() when New Game is clicked
                    onExitGame = { finish() }
                )
            }
        }
    }

    // Start Game and open the GameActivity using Intent
    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}
