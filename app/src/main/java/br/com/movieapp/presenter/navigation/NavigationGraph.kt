package br.com.movieapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.presenter.screens.popular.screen.MoviePopularScreen
import br.com.movieapp.presenter.screens.popular.viewmodel.MoviePopularViewModel
import br.com.movieapp.presenter.screens.search.action.MovieSearchAction
import br.com.movieapp.presenter.screens.search.screen.SearchScreen
import br.com.movieapp.presenter.screens.search.viewmodel.MovieSearchViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {

            val viewModel: MoviePopularViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            MoviePopularScreen(
                uiState = uiState,
                navigateToDetailMovie = {

                }
            )
        }
        composable(BottomNavItem.MovieSearch.route) {

            val viewModel: MovieSearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val onEvent: (MovieSearchAction) -> Unit = viewModel::onValueChange
            val onFetch: (String) -> Unit = viewModel::fetch

            SearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFetch = onFetch,
                navigateToDetailsMovie = {

                }
            )
        }
        composable(BottomNavItem.MovieFavorite.route) {

        }
    }
}