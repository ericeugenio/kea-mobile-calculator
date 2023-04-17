package com.example.calculator.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.mariuszgromada.math.mxparser.Expression

class CalculatorViewModel : ViewModel() {

    // Game UI state
    var userInput by mutableStateOf("0")
        private set

    private var resetInputFlag by mutableStateOf(true)

    fun updateUserInput(newInput: Char) {
        when (newInput) {
            'C' -> reset()
            '=' -> calculate()
            else -> {
                if (resetInputFlag) {
                    userInput = ""
                    resetInputFlag = false
                }

                userInput += newInput
            }
        }
    }

    private fun reset() {
        userInput = "0"
        resetInputFlag = true
    }

    private fun calculate() {
        if (userInput.isNotEmpty()) {
            val expression = Expression(userInput)
            userInput = expression.calculate().toString()
            resetInputFlag = true
        }
    }
}