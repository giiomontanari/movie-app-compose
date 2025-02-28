package br.com.movieapp.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieVO
import kotlinx.coroutines.flow.Flow

interface MoviePopularRepository {

    fun getPopularMovies(pagingConfig: PagingConfig) : Flow<PagingData<MovieVO>>
}