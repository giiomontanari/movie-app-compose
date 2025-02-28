package br.com.movieapp.presenter.screens.search.state

import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieSearchVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MovieSearchState(
    val query: String = "",
    val movies: Flow<PagingData<MovieSearchVO>> = emptyFlow()
)