package yao.ic.words

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import yao.ic.words.ui.screens.DetailScreen
import yao.ic.words.ui.theme.WordsTheme
import yao.ic.words.utils.LETTER
import yao.ic.words.utils.SEARCH_PREFIX

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieves the letter passed from the main screen.
        val letter = "A"
        setContent {
            WordsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen(
                        letter = letter,
                        words = getWordsForLetter(letter),
                        onWordClick = ::onWordClick,
                        onBackClick = { /* Close the current Activity */ }
                    )
                }
            }
        }
    }

    /**
     * Retrieves a list of words that start with the given letter from the resources.
     * @param letter The letter to filter the words by.
     * @return A list of words that start with the given letter.
     *
     * */
    private fun getWordsForLetter(letter: String): List<String> {
        // TODO: Implement a method to retrieve a list of words that start with the given letter.
        // The list of words should be retrieved from the [arrays.xml] file in the resources folder.
        return listOf()
    }

    /**
     * Navigates to a web browser to search for the definition of the clicked word.
     * @param word The word to search for.
     * */
    private fun onWordClick(word: String) {
        // TODO: Implement an implicit intent that navigates to a web browser to search for the
        // definition of the clicked word. Use the [SEARCH_PREFIX] to construct the search URL.
    }
}