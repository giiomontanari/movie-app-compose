package br.com.movieapp.presenter.screens.search.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.presenter.components.searchcontent.SearchContent
import br.com.movieapp.presenter.screens.search.action.MovieSearchAction
import br.com.movieapp.presenter.screens.search.state.MovieSearchState
import br.com.movieapp.presenter.theme.black
import br.com.movieapp.presenter.theme.white

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    uiState: MovieSearchState,
    onEvent: (MovieSearchAction) -> Unit,
    onFetch: (String) -> Unit,
    navigateToDetailsMovie: (Int) -> Unit
) {

    val pagingMovies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.search_movies), color = white)
            })
        },
        backgroundColor = black,
        content = { paddingValues ->
            SearchContent(
                paddingValues = paddingValues,
                paddingMovies = pagingMovies,
                query = uiState.query,
                onSearch = {
                    onFetch(it)
                },
                onEvent = {
                    onEvent(it)
                },
                onDetail = { movieId ->
                    navigateToDetailsMovie(movieId)
                }
            )
        }
    )
}