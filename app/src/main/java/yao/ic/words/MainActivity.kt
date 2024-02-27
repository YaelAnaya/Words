package yao.ic.words

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import yao.ic.words.ui.screens.MainScreen
import yao.ic.words.ui.theme.WordsTheme
import yao.ic.words.utils.LETTER

class MainActivity : ComponentActivity() {
    // Generates a [CharRange] from 'A' to 'Z' and converts it to a list of strings.
    private val letters = ('A'..'Z').map { it.toString() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        letters = letters,
                        onLetterClick = { letter -> goToDetailScreen(letter) }
                    )
                }
            }
        }
    }

    /**
     * Navigates to the detail screen when a letter is clicked in the list.
     * It passes the clicked letter as an argument to the detail screen.
     * @param letter The letter that was clicked.
     * */
    private fun goToDetailScreen(letter: String) {
        // TODO: Implement an explicit intent that navigates to the detail screen.
        // The intent should pass the letter as an argument to the detail screen.
        // Check the Constants file for the key to use when passing the letter as an argument.
        Log.d("MainActivity", "Navigating to detail screen for letter: $letter")
    }
}