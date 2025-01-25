package com.alexaksonov.fifteen_kotlin.domain

class Utils {

    private val DIM = 4

    fun getIndex(row: Int, col: Int) = row * DIM + col

}