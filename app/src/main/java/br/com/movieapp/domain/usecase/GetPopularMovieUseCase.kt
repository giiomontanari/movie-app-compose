package br.com.movieapp.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieVO
import br.com.movieapp.domain.repository.MoviePopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularMovieUseCase {
    operator fun invoke(): Flow<PagingData<MovieVO>>
}

class GetPopularMovieUseCaseImpl @Inject constructor(
    private val repository: MoviePopularRepository
) : GetPopularMovieUseCase {

    override fun invoke(): Flow<PagingData<MovieVO>> {
        return repository.getPopularMovies(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }

}