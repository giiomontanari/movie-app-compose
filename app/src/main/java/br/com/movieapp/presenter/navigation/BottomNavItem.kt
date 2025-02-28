package br.com.movieapp.presenter.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {

    object MoviePopular : BottomNavItem(
        "Filmes Populares",
        icon = Icons.Default.Movie,
        route = "movie_popular_screen"
    )

    object MovieSearch : BottomNavItem(
        "Pesquisar",
        icon = Icons.Default.Search,
        route = "movie_search_screen"
    )

    object MovieFavorite : BottomNavItem(
        "Favoritos",
        icon = Icons.Default.Favorite,
        route = "movie_favorite_screen"
    )
}
