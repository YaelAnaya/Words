package yao.ic.words.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import yao.ic.words.R
import yao.ic.words.ui.components.AppBar

/**
 * This is the detail screen of the app. It displays a list of words that start with the letter
 * passed as an argument. Each word is displayed as a [Button] that, when clicked, navigates to a
 * web page with the definition of the word.
 * @param letter The letter to display.
 * @param words The list of words to display.
 * @param onWordClick The callback/event to be invoked when a word is clicked.
 * @param onBackClick The callback/event to be invoked when the back button is clicked.
 * */
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    letter: String,
    words: List<String> = listOf(),
    onWordClick: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        topBar = { 
            AppBar(
                title = stringResource(id = R.string.detail_appbar_title, letter),
                navigationIcon = { BackNavigationIcon(onBackClick) },
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(words) { word ->
                Button(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    shape = MaterialTheme.shapes.small,
                    onClick = { onWordClick(word) }
                ) {
                    Text(text = word)
                }
            }
        }
    }
}

/**
 * This is a private component that displays a back navigation icon in the app bar.
 * @param onBackClick The callback/event to be invoked when the back button is clicked.
 * */

@Composable
private fun BackNavigationIcon(
    onBackClick: () -> Unit
) {
    IconButton(onClick = onBackClick) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "On Back Icon"
        )
    }
}