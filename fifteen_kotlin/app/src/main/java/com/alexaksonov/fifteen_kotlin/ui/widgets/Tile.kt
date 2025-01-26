package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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

    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = modifier
            .padding(4.dp)
            .border(1.dp, Color.White, RoundedCornerShape(12.dp))
            .size(80.dp)
            .shadow(elevation = 72.dp, clip = false)
            .graphicsLayer(
                clip = true,
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 24f, // Larger shadow
                ambientShadowColor = Color.Black.copy(alpha = 0.5f), // Customize ambient shadow
                spotShadowColor = Color.Black.copy(alpha = 0.5f) // Customize spotlight shadow
            )
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(24.dp),
        shape = RoundedCornerShape(12.dp)

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

@Preview(showBackground = true)
@Composable
fun TilePreview() {
    FifteenKotlinTheme {
        Tile("12", onClick = { true }, backgroundColor = AppColors.Chocolate)
    }
}