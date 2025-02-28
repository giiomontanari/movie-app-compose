package br.com.movieapp.presenter.screens.search.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.domain.usecase.GetMovieSearchUseCase
import br.com.movieapp.presenter.screens.search.action.MovieSearchAction
import br.com.movieapp.presenter.screens.search.state.MovieSearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase
) : ViewModel() {

    var uiState by mutableStateOf(MovieSearchState())
        private set

    fun fetch(query: String = "") {
        val movies = getMovieSearchUseCase.invoke(
            params = GetMovieSearchUseCase.Params(
                query = query
            )
        ).cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }

    fun onValueChange(action: MovieSearchAction) {
        uiState = when (action) {
            is MovieSearchAction.OnValueChange -> {
                uiState.copy(query = action.value)
            }
        }
    }

}