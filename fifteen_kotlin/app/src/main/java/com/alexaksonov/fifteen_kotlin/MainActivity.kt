package com.alexaksonov.fifteen_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import com.alexaksonov.fifteen_kotlin.domain.Utils
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme
import com.alexaksonov.fifteen_kotlin.ui.widgets.Tile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FifteenKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Fifteen", style = TextStyle(
            color = AppColors.Chocolate,
            fontSize = 24.sp,
        ))

        Spacer(Modifier.height(32.dp))

        TileGrid(GameLogic().gameTiles)

        Spacer(Modifier.height(32.dp))

        Row {
            
        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    FifteenKotlinTheme {
        MainScreen()
    }
}

@Composable
fun TileGrid(tiles: List<Int>, modifier: Modifier = Modifier) {

    val utils = Utils()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {

        Column {
            repeat(4) { colIndex ->
                Row {
                    repeat(4) { rowIndex ->

                        val textInt = tiles[utils.getIndex(col = colIndex, row = rowIndex)]
                        Tile(utils.getTextFromIndex(textInt), isEmpty = textInt == GameLogic().emptyIndex)
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
        TileGrid(GameLogic().gameTiles)
    }
}
