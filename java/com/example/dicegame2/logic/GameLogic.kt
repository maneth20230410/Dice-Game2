package com.example.dicegame2.logic

import kotlin.random.Random

// handles rolling dice and calculating scores
class GameLogic {
    private val random = Random.Default

    // given number of dice
    fun rollDice(count: Int): List<Int> {
        return List(count) { random.nextInt(1, 7) }
    }

    //  round of the game
    fun playRound(gameState: GameState): GameState {
        val newPlayerDice = rollDice(5)
        val newComputerDice = rollDice(5)

        val newPlayerGameScore = newPlayerDice.sum()
        val newComputerGameScore = newComputerDice.sum()

        return gameState.copy(
            playerDice = newPlayerDice,
            computerDice = newComputerDice,
            playerGameScore = newPlayerGameScore,
            computerGameScore = newComputerGameScore,
            rollsLeft = gameState.rollsLeft - 1,
            gameOver = gameState.rollsLeft == 1
        )
    }

    // Function to calculate and update the overall score
    fun calculateScore(gameState: GameState): GameState {
        return gameState.copy(
            playerOverallScore = gameState.playerOverallScore + gameState.playerGameScore,
            computerOverallScore = gameState.computerOverallScore + gameState.computerGameScore,
            gameOver = gameState.rollsLeft == 0
        )
    }
}
