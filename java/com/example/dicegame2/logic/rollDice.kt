package com.example.dicegame2.logic

fun rollDice(count: Int): List <Int>{
    return List(count){(1..6).random()}
}