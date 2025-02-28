package br.com.movieapp.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.domain.model.MovieSearchVO
import br.com.movieapp.domain.repository.MovieSearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetMovieSearchUseCase {
    operator fun invoke(params: Params): Flow<PagingData<MovieSearchVO>>
    data class Params(val query: String)
}

class GetMovieSearchUseCaseImpl @Inject constructor(
    private val repository: MovieSearchRepository
) : GetMovieSearchUseCase {

    override fun invoke(params: GetMovieSearchUseCase.Params): Flow<PagingData<MovieSearchVO>> {
        return repository.getSearchMovies(
            query = params.query,
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}