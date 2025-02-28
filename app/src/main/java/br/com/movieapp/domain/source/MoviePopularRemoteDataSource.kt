package br.com.movieapp.domain.source

import br.com.movieapp.core.paging.MoviePagingSource
import br.com.movieapp.data.remote.response.MovieResponse

interface MoviePopularRemoteDataSource {

    fun getPopularMoviesPagingSource() : MoviePagingSource

    suspend fun getPopularMovies(page: Int): MovieResponse
}