package br.com.movieapp.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieSearchVO
import kotlinx.coroutines.flow.Flow

interface MovieSearchRepository {

    fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearchVO>>
}
