package br.com.movieapp.presenter.screens.search.action

sealed class MovieSearchAction {
    data class OnValueChange(val value: String) : MovieSearchAction()
}