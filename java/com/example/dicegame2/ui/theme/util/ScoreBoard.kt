package com.example.dicegame2.ui.theme.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScoreSection(
    title: String,
    playerScore: Int,
    computerScore: Int,
    alignment: Alignment.Horizontal = Alignment.Start,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = alignment,
        modifier = modifier.padding(8.dp)
    ) {
        Text(title, color = Color.White, fontSize = 18.sp)

        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Black, shape = RoundedCornerShape(12.dp))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ScoreBox("H:", playerScore)
            Spacer(modifier = Modifier.width(8.dp))
            ScoreBox("C:", computerScore)
        }
    }
}

@Composable
fun ScoreBox(label: String, score: Int) {
    Surface(
        modifier = Modifier.size(70.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color.Black
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(label, color = Color.White, style = MaterialTheme.typography.bodyMedium)
            Text(score.toString(), color = Color.White, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
