package com.alexaksonov.fifteen_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme
import com.alexaksonov.fifteen_kotlin.ui.widgets.IndicatorColumn
import com.alexaksonov.fifteen_kotlin.ui.widgets.TileGrid

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
        modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Fifteen",
            style = TextStyle(
                color = AppColors.Chocolate,
                fontSize = 24.sp,
            ),
            modifier = Modifier.padding(top = 64.dp)
        )

        TileGrid(
            GameLogic.gameTiles.value,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        UtilityRow()


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
fun UtilityRow(modifier: Modifier = Modifier) {

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {

        IconButton(
            onClick = { GameLogic.onGridReset() },
            modifier = Modifier
                .size(70.dp)
                .background(AppColors.Silver, RoundedCornerShape(12.dp)) // Silver background with circular shape
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh Icon",
                tint = Color.White
            )
        }

        Spacer(Modifier.width(48.dp))

        IndicatorColumn(
            title = "Moves",
            value = GameLogic.movesCount.intValue.toString(),
        )

    }
}
