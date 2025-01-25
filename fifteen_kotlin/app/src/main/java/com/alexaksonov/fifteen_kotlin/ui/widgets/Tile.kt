package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors
import com.alexaksonov.fifteen_kotlin.ui.theme.FifteenKotlinTheme
import com.alexaksonov.fifteen_kotlin.ui.theme.poppinsFontFamily

@Composable
fun Tile(
    tileLabel: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Boolean,
) {

    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
            .size(80.dp)
            .shadow(2.dp, shape = RoundedCornerShape(12.dp), ambientColor = backgroundColor.copy(alpha = 0.5f), spotColor = backgroundColor.copy(alpha = 0.5f)), // Adding custom shadow
        shadowElevation = 12.dp,
        color = backgroundColor,
        onClick = { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                tileLabel,
                style = TextStyle(
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    fontFamily = poppinsFontFamily,
                )
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun TilePreview() {
    FifteenKotlinTheme {
        Tile("12", onClick = { true }, backgroundColor = AppColors.Chocolate)
    }
}