package com.example.dicegame2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dicegame2.ui.theme.DiceGame2Theme
import com.example.dicegame2.ui.theme.screens.GameScreen

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceGame2Theme {
                // Game screen with onBackPress to return to the MainActivity
                GameScreen(onBackPress = { finish() })
            }
        }
    }
}
