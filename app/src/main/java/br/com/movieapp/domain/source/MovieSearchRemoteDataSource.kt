package br.com.movieapp.domain.source

import br.com.movieapp.core.paging.MovieSearchPagingSource
import br.com.movieapp.data.remote.response.SearchResponse

interface MovieSearchRemoteDataSource {

    fun getSearchMoviePagingSource(query: String) : MovieSearchPagingSource

    suspend fun getSearchMovies(page: Int, query: String): SearchResponse
}