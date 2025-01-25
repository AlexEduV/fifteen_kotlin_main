package com.alexaksonov.fifteen_kotlin.domain

class GameLogic {

    val emptyIndex = 16

    private val initTiles = (1..16).toMutableList()
    var gameTiles = generateTiles(initTiles)

    //generate a new sequence
    private fun generateTiles(initTiles: MutableList<Int>): MutableList<Int> {
        val tiles = initTiles
        do {
            tiles.shuffle()
        } while (!isSolvable(tiles))

        return tiles
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
    fun onTileClick(tiles: MutableList<Int>, clickedIndex: Int): Boolean {
        val blankIndex = tiles.indexOf(emptyIndex) // Find the blank tile (16)
        if (isNeighbor(clickedIndex, blankIndex)) {
            // Swap the clicked tile with the blank tile
            tiles[blankIndex] = tiles[clickedIndex]
            tiles[clickedIndex] = emptyIndex
            return true // Swap was successful
        }
        return false // No swap, as the clicked tile isn't a neighbor
    }

    fun onGridReset() {
        gameTiles = generateTiles(initTiles)
    }

    // Check if two tiles are neighbors in the 4x4 grid
    private fun isNeighbor(index1: Int, index2: Int): Boolean {
        val row1 = index1 / 4
        val col1 = index1 % 4
        val row2 = index2 / 4
        val col2 = index2 % 4

        // Two tiles are neighbors if they are adjacent horizontally or vertically
        return (row1 == row2 && kotlin.math.abs(col1 - col2) == 1) || // Horizontal neighbor
                (col1 == col2 && kotlin.math.abs(row1 - row2) == 1)    // Vertical neighbor
    }

    // check the game state
    fun isGameComplete(tiles: MutableList<Int>): Boolean {
        val correctOrder = initTiles
        return tiles == correctOrder
    }

}