package com.alexaksonov.fifteen_kotlin.domain

class GameLogic {

    val EMPTY = 16
    val gameTiles = generateTiles()

    //generate a new sequence
    private fun generateTiles(): MutableList<Int> {
        val tiles = (1..16).toMutableList()
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
    

}