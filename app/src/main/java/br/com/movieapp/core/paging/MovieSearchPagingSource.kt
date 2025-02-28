package br.com.movieapp.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.domain.mapper.toMovieSearchVO
import br.com.movieapp.domain.model.MovieSearchVO
import br.com.movieapp.domain.source.MovieSearchRemoteDataSource
import coil.network.HttpException
import java.io.IOException

class MovieSearchPagingSource(
    private val query: String,
    private val remoteDataSource: MovieSearchRemoteDataSource
) : PagingSource<Int, MovieSearchVO>() {

    override fun getRefreshKey(state: PagingState<Int, MovieSearchVO>): Int? {
        return state.anchorPosition?.let { ancherPosition ->
            val anchorPage = state.closestPageToPosition(ancherPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieSearchVO> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getSearchMovies(page = pageNumber, query = query)
            val movies = response.searchResults

            LoadResult.Page(
                data = movies.toMovieSearchVO(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}
