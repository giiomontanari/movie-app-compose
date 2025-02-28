package br.com.movieapp.presenter.screens.popular.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.movieapp.R
import br.com.movieapp.core.utils.UtilFunctions
import br.com.movieapp.presenter.components.moviecontent.MovieContent
import br.com.movieapp.presenter.screens.popular.state.MoviePopularState
import br.com.movieapp.presenter.theme.black
import br.com.movieapp.presenter.theme.white

@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToDetailMovie: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val movies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )
        },
        content = { paddingValeus ->
            MovieContent(
                pagingMovies = movies,
                paddingValues = paddingValeus,
                onClick = { moveId ->
                    UtilFunctions.logInfo("MOVIE_ID", moveId.toString())
                    navigateToDetailMovie(moveId)
                }
            )
        }
    )
}

@Preview
@Composable
private fun MoviePopularScreenPreview() {

}