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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme
import com.alexaksonov.fifteen_kotlin.ui.theme.poppinsFontFamily
import com.alexaksonov.fifteen_kotlin.ui.widgets.IndicatorColumn
import com.alexaksonov.fifteen_kotlin.ui.widgets.TileGrid
import com.alexaksonov.fifteen_kotlin.ui.widgets.UtilityRow
import com.alexaksonov.fifteen_kotlin.ui.widgets.WinScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FifteenKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding), isWon = GameLogic.isWon.value)
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, isWon: Boolean) {

    Box {
        Column(
            modifier
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                stringResource(R.string.main_screen_title),
                style = TextStyle(
                    color = AppColors.Night,
                    fontSize = 24.sp,
                    fontFamily = poppinsFontFamily
                ),
                modifier = Modifier.padding(top = 64.dp)
            )

            TileGrid(
                GameLogic.gameTiles.value,
                modifier = Modifier.padding(vertical = 32.dp)
            )

            UtilityRow()


        }

        if (isWon) WinScreen()


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    FifteenKotlinTheme {
        MainScreen(isWon = true)
    }
}

