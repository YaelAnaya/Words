package yao.ic.words.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import yao.ic.words.R
import yao.ic.words.ui.theme.WordsTheme

/**
 * A custom [AppBar] that displays the app title and a navigation icon.
 * @param modifier The modifier to be applied to the [AppBar].
 * @param title The title to be displayed in the [AppBar].
 * @param navigationIcon The icon to be displayed as the navigation icon in the [AppBar].
 * */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    navigationIcon: @Composable (() -> Unit) = {},
){
    // A [CenterAlignedTopAppBar] is a [TopAppBar] that aligns the title and navigation icon at the center.
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = navigationIcon,
        // Customizes the colors of the [CenterAlignedTopAppBar].
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview
@Composable
private fun AppBarPreview() {
    WordsTheme {
        AppBar()
    }
}