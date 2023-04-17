package com.example.calculator.ui

import androidx.compose.ui.graphics.Color

data class ButtonData(
    val value: Char,
    val color: Color,
    val onColor: Color
)

val buttonsValues: List<Char> = listOf(
    '1', '2', '3', '+',
    '4', '5', '6', '-',
    '7', '8', '9', '*',
    'C', '0', '=', '/',
)

val buttonsData: List<ButtonData> = buttonsValues.map {
    val color: Color
    val onColor: Color

    when(it) {
        'C' -> {
            color = Color(0xFF0BCCFA)
            onColor = Color.White
        }
        '+', '-', '*', '/', '=' -> {
            color = Color(0xFF017BFD)
            onColor = Color.White
        }
        else -> {
            color = Color(0xFFCDCDCD)
            onColor = Color(0xFF161616)
        }
    }

    ButtonData(it, color, onColor)
}