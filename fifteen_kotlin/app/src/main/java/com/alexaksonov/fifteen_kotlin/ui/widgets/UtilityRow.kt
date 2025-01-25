package com.alexaksonov.fifteen_kotlin.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alexaksonov.fifteen_kotlin.R
import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors

@Composable
fun UtilityRow(modifier: Modifier = Modifier) {

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {

        IconButton(
            onClick = { GameLogic.onGridReset() },
            modifier = Modifier
                .size(70.dp)
                .background(AppColors.Night, RoundedCornerShape(12.dp)) // Silver background with circular shape
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Refresh Icon",
                tint = Color.White
            )
        }

        Spacer(Modifier.width(48.dp))

        IndicatorColumn(
            title = stringResource(R.string.moves),
            value = GameLogic.movesCount.intValue.toString(),
        )

    }
}
