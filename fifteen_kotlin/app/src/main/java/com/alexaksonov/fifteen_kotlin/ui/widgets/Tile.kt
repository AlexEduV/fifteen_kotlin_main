package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme

@Composable
fun Tile(
    tileLabel: String,
    modifier: Modifier = Modifier,
    isEmpty: Boolean = false,
    onClick: () -> Boolean,
) {

    val backgroundColor = if (isEmpty) AppColors.Silver else AppColors.Chocolate

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, AppColors.Silver, RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .size(80.dp)
            .clickable {
                onClick()
            }
    ) {
        Text(tileLabel,
            style = TextStyle(
                fontSize = 32.sp,
                color = AppColors.Silver,
                fontWeight = FontWeight.W600,
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun TilePreview() {
    FifteenKotlinTheme {
        Tile("12", onClick = { true })
    }
}