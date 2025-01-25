package com.alexaksonov.fifteen_kotlin.domain

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import kotlin.math.absoluteValue

class GameLogic {

    companion object {
        const val GRID_SIZE = 4
        const val EMPTY_INDEX = 16
        private val initTiles = (1..16).toList()

        var gameTiles = mutableStateOf(generateTiles())
        var movesCount = mutableIntStateOf(0)
        var isWon = mutableStateOf(false)

        //generate a new sequence
        private fun generateTiles(): List<Int> {
            val tiles = initTiles.toMutableList()
            do {
                tiles.shuffle()
            } while (!isSolvable(tiles))

            return tiles.toList()
        }

        // Check if the arrangement is solvable
        private fun isSolvable(tiles: List<Int>): Boolean {
            var inversions = 0
            val tileCount = tiles.size
            for (i in 0 until tileCount - 1) {
                for (j in i + 1 until tileCount) {
                    if (tiles[i] != 16 && tiles[j] != 16 && tiles[i] > tiles[j]) {
                        inversions++
                    }
                }
            }
            // Find the row of the blank tile (16-based, 1-based index from top to bottom)
            val blankRowFromBottom = 4 - ((tiles.indexOf(16) / 4) + 1) // 16 is the blank tile
            // Puzzle is solvable if:
            // - Inversions are even, and the blank is on an odd row from the bottom
            // - OR inversions are odd, and the blank is on an even row from the bottom
            return (inversions % 2 == 0) == (blankRowFromBottom % 2 != 0)
        }

        //on click, check the neighbouring tiles for empty, and swap current tile with empty
        fun onTileClick(clickedIndex: Int): Boolean {
            val tiles = gameTiles.value.toMutableList()
            val blankIndex = tiles.indexOf(EMPTY_INDEX) // Find the blank tile (16)
            if (isNeighbor(clickedIndex, blankIndex)) {
                // Swap the clicked tile with the blank tile
                tiles[blankIndex] = tiles[clickedIndex]
                tiles[clickedIndex] = EMPTY_INDEX

                //update moves counter
                movesCount.intValue++
                gameTiles.value = tiles.toList()

                isWon.value = isGameComplete(tiles)

                return true // Swap was successful
            }
            return false // No swap, as the clicked tile isn't a neighbor
        }

        fun onGridReset() {
            gameTiles.value = generateTiles()
            movesCount.intValue = 0
            isWon.value = false
        }

        // Check if two tiles are neighbors in the 4x4 grid
        private fun isNeighbor(clickedIndex: Int, blankIndex: Int): Boolean {
            val row1 = clickedIndex / GRID_SIZE
            val col1 = clickedIndex % GRID_SIZE
            val row2 = blankIndex / GRID_SIZE
            val col2 = blankIndex % GRID_SIZE

            // Two tiles are neighbors if they are adjacent horizontally or vertically
            val isNeighbor = (row1 == row2 && (col1 - col2).absoluteValue == 1) ||
                    (col1 == col2 && (row1 - row2).absoluteValue == 1)  // Vertical neighbor

            return isNeighbor
        }

        // check the game state
        fun isGameComplete(tiles: MutableList<Int>): Boolean {
            val correctOrder = initTiles
            return tiles == correctOrder
        }
    }




}