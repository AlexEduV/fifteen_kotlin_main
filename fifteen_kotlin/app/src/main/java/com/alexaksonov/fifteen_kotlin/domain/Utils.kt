package com.alexaksonov.fifteen_kotlin.domain

class Utils {

    private val DIM = 4

    fun getIndex(row: Int, col: Int) = row * DIM + col

    fun getTextFromIndex(index: Int): String {

        val text = if (index == GameLogic().emptyIndex) {
            ""
        } else {
            index.toString()
        }

        return text

    }

}