package com.example.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    calculatorViewModel: CalculatorViewModel = viewModel()
) {
    Column (
        modifier = modifier
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        CalculatorStatus(
            userInput = calculatorViewModel.userInput
        )
        CalculatorButtons(
            onUserInput = calculatorViewModel::updateUserInput
        )
    }
}

@Composable
fun CalculatorStatus (
    userInput: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(22.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.End),
            text = userInput,
            fontSize = 64.sp,
        )
    }
}

@Composable
fun CalculatorButtons (
    onUserInput: (Char) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(buttonsData) { item ->
            Button(
                modifier = Modifier
                    .padding(6.dp)
                    .aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(containerColor = item.color),
                onClick = { onUserInput(item.value) }
            ) {
                Text(
                    text = item.value.toString(),
                    fontSize = 36.sp,
                    color = item.onColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    CalculatorTheme {
        CalculatorScreen()
    }
}