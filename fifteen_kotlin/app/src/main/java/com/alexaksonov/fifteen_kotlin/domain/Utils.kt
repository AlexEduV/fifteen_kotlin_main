package com.alexaksonov.fifteen_kotlin.domain

import androidx.compose.ui.graphics.Color
import com.alexaksonov.fifteen_kotlin.ui.theme.AppColors

class Utils {

    companion object {

        fun getIndex(row: Int, col: Int) = col * GameLogic.GRID_SIZE + row

        fun getTextFromIndex(index: Int): String {

            if (index == GameLogic.EMPTY_INDEX) {
                return ""
            } else {
                return index.toString()
            }

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