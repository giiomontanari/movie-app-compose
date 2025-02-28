package br.com.movieapp.data.remote.datasource

import br.com.movieapp.core.paging.MovieSearchPagingSource
import br.com.movieapp.data.remote.MovieService
import br.com.movieapp.data.remote.response.SearchResponse
import br.com.movieapp.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {

    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page = page, query = query)
    }


}