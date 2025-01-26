package com.alexaksonov.fifteen_kotlin

import com.alexaksonov.fifteen_kotlin.domain.GameLogic
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameLogicTest {

    @Test
    fun gameCompleteRegular() {
        val testInput = buildList {
            addAll(1..16)
        }.toMutableList()

        val result = GameLogic.isGameComplete(testInput)
        assertEquals(result, true)
    }

    @Test
    fun gameCompleteCornerCase() {
        val testInput = buildList {
            addAll(1..14)
            add(16)
            add(15)
        }.toMutableList()

        val result = GameLogic.isGameComplete(testInput)
        assertEquals(result, false)
    }



}