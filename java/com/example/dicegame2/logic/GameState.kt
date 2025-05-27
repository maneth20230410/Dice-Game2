package com.example.dicegame2.logic

import android.os.Parcel
import android.os.Parcelable

data class GameState(
    val playerDice: List<Int> = listOf(1, 2, 5, 4, 6),
    val computerDice: List<Int> = listOf(1, 3, 6, 5, 1),
    val rollsLeft: Int = 3,

    val playerGameScore: Int = 0,  // Score for current game
    val computerGameScore: Int = 0,

    val playerOverallScore: Int = 0,  // Total score across games
    val computerOverallScore: Int = 0,

    val gameOver: Boolean = false
) : Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeIntArray(playerDice.toIntArray())
        parcel.writeIntArray(computerDice.toIntArray())
        parcel.writeInt(rollsLeft)
        parcel.writeInt(playerGameScore)
        parcel.writeInt(computerGameScore)
        parcel.writeInt(playerOverallScore)
        parcel.writeInt(computerOverallScore)
        parcel.writeByte(if (gameOver) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<GameState> {
        override fun createFromParcel(parcel: Parcel): GameState {
            return GameState(
                playerDice = parcel.createIntArray()?.toList() ?: listOf(1, 1, 1, 1, 1),
                computerDice = parcel.createIntArray()?.toList() ?: listOf(1, 1, 1, 1, 1),
                rollsLeft = parcel.readInt(),
                playerGameScore = parcel.readInt(),
                computerGameScore = parcel.readInt(),
                playerOverallScore = parcel.readInt(),
                computerOverallScore = parcel.readInt(),
                gameOver = parcel.readByte() != 0.toByte()
            )
        }

        override fun newArray(size: Int): Array<GameState?> = arrayOfNulls(size)
    }
}
