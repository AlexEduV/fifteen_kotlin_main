package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme

@Composable
fun Tile(tileLabel: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.Silver)
            .width(50.dp)
            .height(50.dp),
    ) {
        Text(tileLabel)
    }
}

@Preview(showBackground = false)
@Composable
fun TilePreview() {
    FifteenKotlinTheme {
        Tile("12")
    }
}