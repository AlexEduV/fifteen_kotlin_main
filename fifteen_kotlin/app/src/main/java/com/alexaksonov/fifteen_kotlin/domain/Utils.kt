package com.alexaksonov.fifteen_kotlin.domain

import androidx.compose.ui.graphics.Color
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors

class Utils {

    companion object {

        fun getIndex(row: Int, col: Int) = row * GameLogic.GRID_SIZE + col

        fun getTextFromIndex(index: Int): String {

            val text = if (index == GameLogic.EMPTY_INDEX) {
                ""
            } else {
                index.toString()
            }

            return text

        }

        fun getTileColor(index: Int): Color {

            if (index == GameLogic.EMPTY_INDEX) {
                return AppColors.Silver
            }
            else {
                if (index % 2 == 0) {
                    return AppColors.Viridian
                }
                else {
                    return AppColors.Chocolate
                }

            }

        }
    }

}