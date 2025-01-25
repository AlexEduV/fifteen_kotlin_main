package com.alexaksonov.fifteen_kotlin.domain

class Utils {

    companion object {

        fun getIndex(row: Int, col: Int) = row * GameLogic.GRID_SIZE + col

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