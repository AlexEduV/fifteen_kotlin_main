package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import com.alexaksonov.fifteen_kotlin.domain.Utils
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme

@Composable
fun TileGrid(tiles: List<Int>, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Column {
            repeat(GameLogic.GRID_SIZE) { colIndex ->
                Row {
                    repeat(GameLogic.GRID_SIZE) { rowIndex ->

                        val index = Utils.getIndex(rowIndex, colIndex)
                        val textInt = tiles[index]
                        Tile(
                            Utils.getTextFromIndex(textInt),
                            isEmpty = textInt == GameLogic.EMPTY_INDEX,
                            onClick = {
                                GameLogic.onTileClick(index)
                            }
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = false)
@Composable
fun GridPreview() {
    FifteenKotlinTheme {
        TileGrid(GameLogic.gameTiles.value)
    }
}
