package br.com.movieapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.presenter.screens.popular.screen.MoviePopularScreen
import br.com.movieapp.presenter.screens.popular.viewmodel.MoviePopularViewModel

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

        }
        composable(BottomNavItem.MovieFavorite.route) {

        }
    }
}