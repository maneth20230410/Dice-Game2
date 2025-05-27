package com.example.dicegame2.ui.theme.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.dicegame2.R

@Composable
fun getDiceImage(dice: Int): Painter{
    return when(dice){
        1 -> painterResource(R.drawable.dice_1)
        2 -> painterResource(R.drawable.dice_2)
        3 -> painterResource(R.drawable.dice_3)
        4 -> painterResource(R.drawable.dice_4)
        5 -> painterResource(R.drawable.dice_5)
        else -> painterResource(R.drawable.dice_6)
    }
}