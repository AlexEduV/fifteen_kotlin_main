package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme

@Composable
fun IndicatorColumn(modifier: Modifier = Modifier, title: String, value: String) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            title,
            style = TextStyle(fontWeight = FontWeight.W500, fontSize = 16.sp),
        )

        Text(
            value,
            style = TextStyle(fontWeight = FontWeight.W500, fontSize = 32.sp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorColumnPreview() {
    FifteenKotlinTheme {
        IndicatorColumn(
            title = "Title",
            value = "0"
        )
    }
}
