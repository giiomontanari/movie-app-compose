package br.com.movieapp.presenter.screens.popular.state

import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieVO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviePopularState(
    val movies: Flow<PagingData<MovieVO>> = emptyFlow()
)
