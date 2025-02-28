package br.com.movieapp.presenter.components.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.movieapp.R
import br.com.movieapp.presenter.screens.search.action.MovieSearchAction
import br.com.movieapp.presenter.theme.white
import retrofit2.http.Query

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    query: String,
    onSearch: (String) -> Unit,
    onQueryChangeEvent: (MovieSearchAction) -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = {
            onQueryChangeEvent(MovieSearchAction.OnValueChange(it))
        },
        trailingIcon = {
            IconButton(
                onClick = { onSearch(query) },
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = null
                    )
                }
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_movies)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Sentences,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query)
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = white,
            cursorColor = white,
            placeholderColor = white,
            trailingIconColor = white
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(60.dp)
    )
}

@Preview
@Composable
private fun SearchItemPreview() {
    SearchItem(
        query = "",
        onSearch = {},
        onQueryChangeEvent = {}
    )
}