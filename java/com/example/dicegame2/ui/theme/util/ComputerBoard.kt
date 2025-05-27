package com.example.dicegame2.ui.theme.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.dicegame2.logic.rollDice
import androidx.compose.runtime.*

@Composable
fun Compterboard (): List<Int> {
    return remember { rollDice(5) }
}