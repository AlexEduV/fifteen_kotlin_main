package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme

@Composable
fun Tile(tileLabel: String, modifier: Modifier = Modifier, isEmpty: Boolean = false) {

    val backgroundColor = if (isEmpty) AppColors.Silver else AppColors.Chocolate

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.Silver, RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .width(60.dp)
            .height(60.dp),
    ) {
        Text(tileLabel,
            style = TextStyle(
                fontSize = 24.sp,
                color = AppColors.Silver,
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun TilePreview() {
    FifteenKotlinTheme {
        Tile("12", isEmpty = true)
    }
}