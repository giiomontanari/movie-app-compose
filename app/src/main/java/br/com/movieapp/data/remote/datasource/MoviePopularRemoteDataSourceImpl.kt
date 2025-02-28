package br.com.movieapp.data.remote.datasource

import br.com.movieapp.core.paging.MoviePagingSource
import br.com.movieapp.data.remote.MovieService
import br.com.movieapp.data.remote.response.MovieResponse
import br.com.movieapp.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {

    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page = page)
    }
}