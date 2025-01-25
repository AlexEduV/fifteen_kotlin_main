package com.alexaksonov.fifteen_kotlin.domain

class Utils {

    companion object {

        private val DIM = 4

        fun getIndex(row: Int, col: Int) = row * DIM + col

        fun getTextFromIndex(index: Int): String {

            val text = if (index == GameLogic.EMPTY_INDEX) {
                ""
            } else {
                index.toString()
            }

            return text

        }
    }

}