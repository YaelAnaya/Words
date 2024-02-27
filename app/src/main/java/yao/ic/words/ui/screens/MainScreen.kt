package yao.ic.words.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import yao.ic.words.ui.components.AppBar

/**
 * This is the main screen of the app. It displays a list of letters from 'A' to 'Z' using a
 * [LazyColumn]. Each letter is displayed as a [Button] that, when clicked, navigates to the detail
 * screen.
 * @param letters The list of letters to display.
 * @param onLetterClick The callback/event to be invoked when a letter is clicked.
 * */

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    letters: List<String> = listOf(),
    onLetterClick: (String) -> Unit = {},
) {
    /* A [Scaffold] is a layout component that provides a material design scaffold for the app.
     In this case, it provides a [TopAppBar] and a content area for the [LazyColumn] that displays
     the list of letters. */
    Scaffold(
        modifier = modifier,
        topBar = { AppBar() }
    ) { innerPadding -> // innerPadding is the padding applied by the Scaffold to the content.
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(letters) { letter ->
                Button(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    shape = MaterialTheme.shapes.small,
                    onClick = { onLetterClick(letter) }
                ) {
                    Text(text = letter)
                }
            }
        }
    }
}
