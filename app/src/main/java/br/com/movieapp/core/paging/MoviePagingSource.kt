package br.com.movieapp.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.domain.mapper.toMovieVO
import br.com.movieapp.domain.model.MovieVO
import br.com.movieapp.domain.source.MoviePopularRemoteDataSource
import coil.network.HttpException
import okio.IOException

class MoviePagingSource constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : PagingSource<Int, MovieVO>() {

    override fun getRefreshKey(state: PagingState<Int, MovieVO>): Int? {
        return state.anchorPosition?.let { ancherPosition ->
            val anchorPage = state.closestPageToPosition(ancherPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieVO> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(pageNumber)
            val movies = response.movieResults

            LoadResult.Page(
                data = movies.toMovieVO(),
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