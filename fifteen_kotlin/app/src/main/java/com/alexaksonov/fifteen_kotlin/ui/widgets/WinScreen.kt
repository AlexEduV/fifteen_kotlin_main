package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.alexaksonov.fifteen_kotlin.R
import com.alexaksonov.fifteen_kotlin.ui.theme.poppinsFontFamily

@Composable
fun WinScreen(modifier: Modifier = Modifier) {

    Column(
        modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            stringResource(R.string.win_phrase),
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp
            )
        )

        Spacer(Modifier.height(16.dp))

        UtilityRow()

    }
}

@Preview
@Composable
fun WinScreenPreview(modifier: Modifier = Modifier) {
    WinScreen()
}