package br.com.movieapp.presenter.screens.popular.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.domain.usecase.GetPopularMovieUseCase
import br.com.movieapp.presenter.screens.popular.state.MoviePopularState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase
) : ViewModel() {

    var uiState by mutableStateOf(MoviePopularState())
        private set

    init {
        val movies = getPopularMovieUseCase.invoke().cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }
}
